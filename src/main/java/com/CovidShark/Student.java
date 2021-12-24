package com.CovidShark;

import com.google.common.collect.EvictingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Student extends BaseUser {

    private String about;
    private int formSymptomNumber;
    private int prizePoints;
    ArrayList< Form > consecutiveDays;

    private Dormitory dorm;
    private Form form;

    private List<Course> coursesTaken;
    private List<Section> sections;
    private List<VisitedRoom> roomHistory;
    private List<VisitedRoom> dailyRooms;
    private List<SwapRequest> swapRequests;
    //private List<String> seats;



    public Student(String idNumber, String name, String email, String phoneNumber) {

        super(idNumber, name, email, phoneNumber);
        this.about = "Hey I'm a student at Bilkent University";
        formSymptomNumber = 0;
        prizePoints = 0;

        dorm = null;
        form = new Form();

        coursesTaken = new ArrayList<Course>();
        sections = new ArrayList<Section>();
        roomHistory = new ArrayList<VisitedRoom>();
        dailyRooms = new ArrayList<VisitedRoom>();

        swapRequests = new ArrayList<SwapRequest>();
        //seats = null;
        consecutiveDays = new ArrayList<Form>();

    }

    // basic operations
    public String getAbout() {
        return about;
    }
    public void setAbout(String aboutMeDescription) {
        about = aboutMeDescription;
    }

    public int getPrizePoint() {
        return prizePoints;
    }

    public boolean usePrizePoints(int pricePoint){
        if (prizePoints <= pricePoint){
            prizePoints = prizePoints - pricePoint;
            return true;
        }
        return false;
    }

    // form operations
    public void answerQuestion(boolean answer, int questionNum){
        form.answerQuestion(answer, questionNum);
    }

    public boolean submitForm() {
        if (form.answeredAll()){
            formSymptomNumber = 0;

            consecutiveDays.add(new Form(java.util.Calendar.getInstance().getTime()));
            if(consecutiveDays.size() <= 5)
            {
                for (int i = 0; i < consecutiveDays.size(); i++)
                {
                    formSymptomNumber = formSymptomNumber +  consecutiveDays.get(i).getSymptomNumber();
                }
                prizePoints = prizePoints + 5;
               // form.resetForm();
            }
            else
            {
                consecutiveDays.remove(0);
                for (int i = 0; i < consecutiveDays.size(); i++)
                {
                    formSymptomNumber = formSymptomNumber +  consecutiveDays.get(i).getSymptomNumber();
                }
                prizePoints = prizePoints + 5;
              //  form.resetForm();
            }
            return true;
        }
        return false;
    }

    // resetting formSymptomNumber to zero after 5 days
    // request pcr test after ... days
    public int getCurrentSymptoms() {
        return formSymptomNumber;
    }

    public void warnUser(){

        if(consecutiveDays.get(0).)

    }

    // dorm operations
    public void setDorm(Dormitory dorm){
        this.dorm = dorm;
    }
    public Dormitory getDorm(int dormNumber) {
        return dorm;
    }
    public boolean isStudentInDorm() {
        return dorm == null;
    }


    // section op

    public List<Section> getSections() {
        return sections;
    }

    public Section getSection(String courseSection) {
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionNo().equals(courseSection)) {
                return sections.get(i);
            }
        }
        return null;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void addSection(Section section){
        sections.add(section);
    }

    public boolean removeSection(String sectionNo){
        for (int i = 0; i < sections.size() ; i++)
        {
            if(sections.get(i).getSectionNo().equals(sectionNo)) {
                sections.remove(i);
                return true;
            }
        }
        return false;
    }


    // course op
    public List<Course> getCoursesTaken() {
        return coursesTaken;
    }

    public void setCourses(List<Course> coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public Course getCourse(String courseCode) {
        for(int i = 0 ; i < coursesTaken.size() ; i++)
        {
            if(coursesTaken.get(i).getCourseCode().equals(courseCode))
            {
                return coursesTaken.get(i);
            }
        }
        return null;
    }


    public void addCourse(Course course){
       coursesTaken.add(course);
    }

    public boolean removeCourse(String courseCode){
        for (int i = 0; i < coursesTaken.size() ; i++)
        {
            if(coursesTaken.get(i).getCourseCode().equals(courseCode))
            {
                coursesTaken.remove(i);
                return true;
            }
        }
        return false;
    }


    // room history op
    public void addRoomToHistory(VisitedRoom room) {
        dailyRooms.add(room);
    }

    public void submitRoomHistory() {
        prizePoints = prizePoints + 10;
        roomHistory.addAll(dailyRooms);
        dailyRooms.clear();
    }

    //Seat op

    public boolean swapRequestExists(int requestCode){
        for (int i = 0; i < swapRequests.size(); i++)  {
            if (swapRequests.get(i).getNotificationCode() == requestCode)
                return true;
        }
        return false;
    }

    public SwapRequest getSwapRequest(int code) {
        for (int i = 0; i < swapRequests.size(); i++) {
            if (swapRequests.get(i).getNotificationCode() == code) {
                return swapRequests.get(i);
            }
        }
        return null;
    }

    public boolean bothHaveSeats(Student sender, Student receiver, Section section){
        if ( sender != null && receiver != null && section != null  &&
                section.getSeatingPlan().hasSeat(sender) && section.getSeatingPlan().hasSeat(receiver))
            return true;
        else
            return false;
    }

    private void addSwapRequest(SwapRequest sR){
        swapRequests.add(sR);
    }

    public boolean selectSeat(String seatNum, String sectionCode){
        for (int i = 0; i < sections.size(); i++){
            if (Objects.equals(sections.get(i).getSectionNo(), sectionCode)){
                boolean result = sections.get(i).getSeatingPlan().selectSeat(seatNum, this);
                return result;
            }
        }
        return false;
    }


    public void createSwapRequest(String seatNo, String courseSection) {

        // find the student seating on desired seat
        Section currentSec = getSection(courseSection);
        Student s = currentSec.getSeatingPlan().getStudent(seatNo);

        if (bothHaveSeats(this, s, currentSec)){
            // 1) get requesters seat
            String mySeat = currentSec.getSeatingPlan().getSeat(this);

            // 2) create swap request messages for both students
            String msgForSender = "You want to have a swap for your seat:" + mySeat + " with the seat: " + seatNo + " in section: " + courseSection;
            String msgForReceiver = this.getName() + "wants to swap your seat:" + seatNo +
                    " with the seat: " + mySeat + " in section: " + courseSection;

            // 3) create swap requests for both students
            // 3.1: for requester
            SwapRequest request = new SwapRequest(msgForSender, seatNo, s, this, currentSec);
            addSwapRequest(request);

            // 3.2: for receiver
            SwapRequest request2 = new SwapRequest(msgForReceiver, seatNo, s, this, currentSec);
            s.addSwapRequest(request2);
        }
    }

    public boolean cancelSwapRequest(int requestCode) {
        if ( swapRequestExists(requestCode) ){
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
            for (i = 0; i < receiver.swapRequests.size(); i++)  {
                if (receiver.swapRequests.get(i).getNotificationCode() == requestCode){
                    // 1) set request as cancelled (optional)
                    receiver.swapRequests.get(i).markAsCancelled();
                    // 2) remove the request from receiver
                    receiver.swapRequests.remove(i);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    // Important: This will be done by owner/receiver
    public void rejectSwapRequest(int requestCode) {
        if ( swapRequestExists(requestCode) ){
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
            for (i = 0; i < requester.swapRequests.size(); i++)  {
                if (requester.swapRequests.get(i).getNotificationCode() == requestCode){
                    // 1) set request as rejected (optional)
                    requester.swapRequests.get(i).markAsRejected();
                    // 2) remove the request from receiver
                    requester.swapRequests.remove(i);
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
    public void acceptSwapRequest(int requestCode) {

             // make swap operation if request exists
             if ( swapRequestExists(requestCode) ){

                 SwapRequest sr = getSwapRequest(requestCode);
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
                 for (i = 0; i < requester.swapRequests.size(); i++)  {
                     if (requester.swapRequests.get(i).getNotificationCode() == requestCode){
                         // 1) set request as rejected (optional)
                         requester.swapRequests.get(i).markAsAccepted();
                         // 2) remove the request from receiver
                         requester.swapRequests.remove(i);
                         break;
                     }
                 }


                 // send notification that swap request is accepted!!!
                 String msg = "Your request for seat: " + sR.getSeat() + " in section: " + sR.getSection() + " is accepted!!!";
                 Notification notification = new Notification(msg, "ACCEPTION", "SYSTEM");
                 requester.addNotification(notification) ;
             }
    }

    public void rejectAllSwapRequest() {
        for (int i = 0; i < swapRequests.size(); i++) {
            swapRequests.get(i).markAsRejected();
        }
    }
}
