package com.CovidShark;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SectionFacade class for the FAÇADE design pattern.
 */
public class SectionFacade {

    //private List<Section> sections;
    //private SeatingPlan seatingPlan;

    //private List<SwapRequest> swapRequests;
    //private Student student;

    public SectionFacade() {
        //sections = new ArrayList<Section>();
        //swapRequests = new ArrayList<SwapRequest>();
    }

    /*
    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void setSwapRequests(List<SwapRequest> swapRequest) {
        this.swapRequests = swapRequests;
    }

     */

    /**
     * swapRequestExists(List<SwapRequest> swapRequests, int requestCode) operation checks if a swap request exists.
     * @return true if operation is successful, false otherwise.
     */
    private boolean swapRequestExists(List<SwapRequest> swapRequests, int requestCode){
        for (int i = 0; i < swapRequests.size(); i++)  {
            if (swapRequests.get(i).getNotificationCode() == requestCode)
                return true;
        }
        return false;
    }

    /**
     * swapRequestExists(List<SwapRequest> swapRequests, int requestCode) operation gets a swap request by its code.
     * @return the swap request if operation is successful, null otherwise.
     */
    private SwapRequest getSwapRequest(List<SwapRequest> swapRequests, int code) {
        for (int i = 0; i < swapRequests.size(); i++) {
            if (swapRequests.get(i).getNotificationCode() == code) {
                return swapRequests.get(i);
            }
        }
        return null;
    }

    /**
     * bothHaveSeats(Student sender, Student receiver, Section section) checks if both students have proper seats.
     * @return true if both students have seats, false otherwise.
     */
    private boolean bothHaveSeats(Student sender, Student receiver, Section section){
        if ( sender != null && receiver != null && section != null  &&
                section.getSeatingPlan().hasSeat(sender) && section.getSeatingPlan().hasSeat(receiver))
            return true;
        else
            return false;
    }
    /**
     * private void addSwapRequest(List<SwapRequest> swapRequests,SwapRequest sR) operation adds a request.
     */
    private void addSwapRequest(List<SwapRequest> swapRequests,SwapRequest sR){
        swapRequests.add(sR);
    }

    /**
     * getSection(List<Section> sections, String courseSection) operation gets a section.
     * @return the sections if operation is successful, null otherwise.
     */
    private Section getSection(List<Section> sections, String courseSection) {
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionNo().equals(courseSection)) {
                return sections.get(i);
            }
        }
        return null;
    }

    // USER MANUEL PART.....
    public boolean selectSeat(String seatNum, String sectionCode, List<Section> sections, Student s){
        for (int i = 0; i < sections.size(); i++){
            if (Objects.equals(sections.get(i).getSectionNo(), sectionCode)){
                boolean result = sections.get(i).getSeatingPlan().selectSeat(seatNum, s);
                return result;
            }
        }
        return false;
    }

    public void createSwapRequest(Student stu, String seatNo, List<Section> sections, String courseSection, List<SwapRequest> swapRequests) {

        // find the student seating on desired seat
        Section currentSec = getSection(sections, courseSection);
        Student s = currentSec.getSeatingPlan().getStudent(seatNo);

        if (bothHaveSeats(stu, s, currentSec)){
            // 1) get requesters seat
            String mySeat = currentSec.getSeatingPlan().getSeat(stu);

            // 2) create swap request messages for both students
            String msgForSender = "You want to have a swap for your seat:" + mySeat + " with the seat: " + seatNo + " in section: " + courseSection;
            String msgForReceiver = stu.getName() + "wants to swap your seat:" + seatNo +
                    " with the seat: " + mySeat + " in section: " + courseSection;

            // 3) create swap requests for both students
            // 3.1: for requester
            SwapRequest request = new SwapRequest(msgForSender, seatNo, s, stu, currentSec);
            addSwapRequest( swapRequests, request);

            // 3.2: for receiver
            SwapRequest request2 = new SwapRequest(msgForReceiver, seatNo, s, stu, currentSec);
            s.addSwapRequest(request2);
        }
    }

    public boolean cancelSwapRequest(int requestCode, List<SwapRequest> swapRequests) {
        if ( swapRequestExists(swapRequests, requestCode) ){
            // find the request from requester and delete it
            int i;
            for (i = 0; i < swapRequests.size(); i++)  {
                if (swapRequests.get(i).getNotificationCode() == requestCode){
                    // 1) set request as cancelled (optional)
                    swapRequests.get(i).markAsCancelled();
                    // 2) remove the request from requester
                    swapRequests.remove(i);
                    break;
                }
            }

            Student receiver = swapRequests.get(i).getSeatOwner();
            // find the request from receiver and delete it
            for (i = 0; i < receiver.getSwapRequests().size(); i++)  {
                if (receiver.getSwapRequests().get(i).getNotificationCode() == requestCode){
                    // 1) set request as cancelled (optional)
                    receiver.getSwapRequests().get(i).markAsCancelled();
                    // 2) remove the request from receiver
                    receiver.getSwapRequests().remove(i);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    // Important: This will be done by owner/receiver
    public void rejectSwapRequest(List<SwapRequest> swapRequests, int requestCode) {
        if ( swapRequestExists(swapRequests, requestCode) ){
            // find the request from me and delete it
            int i;
            for (i = 0; i < swapRequests.size(); i++)  {
                if (swapRequests.get(i).getNotificationCode() == requestCode){
                    // 1) set request as rejected  (optional)
                    swapRequests.get(i).markAsRejected();
                    // 2) remove the request from requester
                    swapRequests.remove(i);
                    break;
                }
            }

            SwapRequest sR = swapRequests.get(i);
            Student requester = sR.getRequester();
            // find the request from requester and delete it
            for (i = 0; i < requester.getSwapRequests().size(); i++)  {
                if (requester.getSwapRequests().get(i).getNotificationCode() == requestCode){
                    // 1) set request as rejected (optional)
                    requester.getSwapRequests().get(i).markAsRejected();
                    // 2) remove the request from receiver
                    requester.getSwapRequests().remove(i);
                    break;
                }
            }

            // send a notification to the requester that the request is being rejected!!!
            String msg = "Your request for seat: " + sR.getSeat() + " in section: " + sR.getSection() + " is rejected!!!";
            Notification notification = new Notification(msg, "REJECTION", "SYSTEM");
            requester.addNotification(notification) ;
        }
    }

    // Important: This will be done by owner/receiver
    public void acceptSwapRequest(List<SwapRequest> swapRequests, int requestCode, List<Section> sections) {

        // make swap operation if request exists
        if ( swapRequestExists(swapRequests, requestCode) ){

            SwapRequest sr = getSwapRequest(swapRequests, requestCode);
            // reach out to seating plan of the section
            for (int i = 0; i < sections.size(); i++){
                if ( Objects.equals(sections.get(i).getSectionNo(), sr.getSection().getSectionNo()))  {
                    // make the seating plan do swap operation
                    sections.get(i).getSeatingPlan().swapSeats(sr.getRequester(), sr.getSeatOwner());
                }
            }

            // delete the requests from both
            // first the seat owner/receiver
            int i;
            for (i = 0; i < swapRequests.size(); i++)  {
                if (swapRequests.get(i).getNotificationCode() == requestCode){
                    // 1) set request as accepted (optional)
                    swapRequests.get(i).markAsAccepted();
                    // 2) remove the request from requester
                    swapRequests.remove(i);
                    break;
                }
            }

            // then the seat requester
            SwapRequest sR = swapRequests.get(i);
            Student requester = sR.getRequester();
            // find the request from receiver and delete it
            for (i = 0; i < requester.getSwapRequests().size(); i++)  {
                if (requester.getSwapRequests().get(i).getNotificationCode() == requestCode){
                    // 1) set request as rejected (optional)
                    requester.getSwapRequests().get(i).markAsAccepted();
                    // 2) remove the request from receiver
                    requester.getSwapRequests().remove(i);
                    break;
                }
            }

            // send notification that swap request is accepted!!!
            String msg = "Your request for seat: " + sR.getSeat() + " in section: " + sR.getSection() + " is accepted!!!";
            Notification notification = new Notification(msg, "ACCEPTION", "SYSTEM");
            requester.addNotification(notification) ;
        }
    }
}
