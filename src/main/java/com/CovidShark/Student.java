package com.CovidShark;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Student class extends the BaseUser class.
 */
public class Student extends BaseUser {

    /**
     * The about String holds the about information of a student.
     */
    private String about;

    /**
     * The formSymptomNumber integer holds the form symptom number.
     */
    private int formSymptomNumber;

    /**
     * The prizePoints integer holds the prize points.
     */
    private int prizePoints;

    /**
     * The consecutiveDays integer list holds the consecutive days.
     */
    ArrayList< Integer > consecutiveDays;

    /**
     * The consecutiveForms integer list holds the consecutive forms.
     */
    ArrayList< Form > consecutiveForms;

    /**
     * The dorm object holds the dorm.
     */
    private Dormitory dorm;

    /**
     * The form object holds the form.
     */
    private Form form;

    /**
     * The coursesTaken course list holds the courses taken by a student.
     */
    private List<Course> coursesTaken;

    /**
     * The sections section list holds the sections of a student.
     */
    private List<Section> sections;

    /**
     * The roomHistory visited room list holds the room history of a student.
     */
    private List<VisitedRoom> roomHistory;

    /**
     * The dailyRooms visited room list holds the daily rooms of a student.
     */
    private List<VisitedRoom> dailyRooms;

    /**
     * The swapRequests swap request list holds the swap requests of a student.
     */
    private List<SwapRequest> swapRequests;

    /**
     * The FAÇADE design pattern
     */
    SectionFacade sectionFacade;

    public Student(String idNumber, String name, String email, String phoneNumber) {

        this.setIdNumber(idNumber);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(null);

        this.about = "Hey I'm a student at Bilkent University";
        formSymptomNumber = 0;
        prizePoints = 0;

        dorm = null;
        form = new Form();
        form.addQuestions();

        coursesTaken = new ArrayList<Course>();
        sections = new ArrayList<Section>();
        roomHistory = new ArrayList<VisitedRoom>();
        dailyRooms = new ArrayList<VisitedRoom>();

        swapRequests = new ArrayList<SwapRequest>();
        //seats = null;
        consecutiveDays = new ArrayList<Integer>();
        consecutiveForms = new ArrayList<Form>();

        sectionFacade = new SectionFacade();

    }

    public Student(){

    }

    public void init(String idNumber, String name, String email, String phoneNumber){

        this.setIdNumber(idNumber);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(null);

        this.about = "Hey I'm a student at Bilkent University";
        formSymptomNumber = 0;
        prizePoints = 0;

        dorm = null;
        form = new Form();
        form.addQuestions();

        coursesTaken = new ArrayList<Course>();
        sections = new ArrayList<Section>();
        roomHistory = new ArrayList<VisitedRoom>();
        dailyRooms = new ArrayList<VisitedRoom>();

        swapRequests = new ArrayList<SwapRequest>();
        //seats = null;
        consecutiveDays = new ArrayList<Integer>();
        consecutiveForms = new ArrayList<Form>();

        sectionFacade = new SectionFacade();
    }


    // basic operations

    /**
     * The getAbout() operation gets the about of a student.
     * @return the about.
     */
    public String getAbout() {
        return about;
    }

    /**
     * The setAbout(String aboutDescription) sets the about of a student.
     */
    public void setAbout(String aboutMeDescription) {
        about = aboutMeDescription;
    }

    /**
     * The getPrizePoint() operation gets the prize points of a student.
     * @return the prize points.
     */
    public int getPrizePoint() {
        return prizePoints;
    }

    /**
     * The usePrizePoints(int prizePoint) operation uses the prize points of a student.
     * For example, student can buy coffee with the points.
     * @return true if prizePoints <= pricePoints, false otherwise
     */
    public boolean usePrizePoints(int pricePoint){
        if (prizePoints <= pricePoint){
            prizePoints = prizePoints - pricePoint;
            return true;
        }
        return false;
    }

    // form operations

    /**
     * The answerQuestion(boolean answer, int questionNum) operation answers a question.
     */
    public void answerQuestion(boolean answer, int questionNum){
        form.answerQuestion(answer, questionNum);
    }

    /**
     * The submitForm() operation submits the form.
     * @return true if all answers are answered, false otherwise.
     */
    public boolean submitForm() {
        if (form.answeredAll()){
            formSymptomNumber = 0;

            consecutiveDays.add(form.getSymptomNumber());
            consecutiveForms.add(form);
            if(consecutiveDays.size() <= 5)
            {
                for (int i = 0; i < consecutiveDays.size(); i++)
                {
                    formSymptomNumber = formSymptomNumber +  consecutiveDays.get(i);
                }
            }
            else
            {
                consecutiveDays.remove(0);
                for (int i = 0; i < consecutiveDays.size(); i++)
                {
                    formSymptomNumber = formSymptomNumber +  consecutiveDays.get(i);
                }
            }
            prizePoints = prizePoints + 5;
            form.resetForm();

            warnUserForNotFilled();
            warnUserForSymptomNum();
            return true;
        }
        return false;
    }

    // resetting formSymptomNumber to zero after 5 days
    // request pcr test after ... days

    /**
     * The getCurrentSymptoms() operation gets the current symptoms of a student.
     * @return the form symptom number.
     */
    public int getCurrentSymptoms() {
        return formSymptomNumber;
    }

    /**
     * The warnUserForNotFilled() operation warns a user if the user has not filled and submitted the form in
     * 5 consecutive days.
     */
    public void warnUserForNotFilled(){
        LocalDate date1 = consecutiveForms.get(consecutiveForms.size() - 1).getFormDate();
        LocalDate date2 = consecutiveForms.get(consecutiveForms.size() - 2).getFormDate();

        long noOfDaysBetween = ChronoUnit.DAYS.between((Temporal) date1, (Temporal) date2);

        if(noOfDaysBetween > 5)
        {
            Notification newNotif = new Notification("You should give PCR test to the Health Center","Warning", "CovidShark");
            addNotification(newNotif);
            getHealthStatus().setCampusPermission(false);
        }
    }

    /**
     * The warnUserForSymptomNum() operation warns the user if the user has filled more than 15 symptoms in 5 days.
     */
    public void warnUserForSymptomNum(){
        if(formSymptomNumber > 15)
        {
            Notification newNotif2 = new Notification("You should give PCR test to the Health Center","Warning", "CovidShark");
            addNotification(newNotif2);
            getHealthStatus().setCampusPermission(false);
        }
    }

    // dorm operations

    /**
     * The setDorm(Dormitory dorm) operation sets the dorm.
     */
    public void setDorm(Dormitory dorm){
        this.dorm = dorm;
    }

    /**
     * The getDorm(int dormNumber) operation gets the dorm.
     * @return the dorm.
     */
    public Dormitory getDorm(int dormNumber) {
        return dorm;
    }

    /**
     * The isStudentInDorm() operation checks if the student stays at dorms or not.
     * @return if a student stays at dorm or not.
     */
    public boolean isStudentInDorm() {
        return dorm == null;
    }

    // section op

    /**
     * The getSections() operation gets the sections.
     * @return the sections.
     */
    public List<Section> getSections() {
        return sections;
    }

    /**
     * The getSection(String courseSection) operation gets a single section.
     * @return the section if operation is successful, null otherwise.
     */
    public Section getSection(String courseSection) {
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionNo().equals(courseSection)) {
                return sections.get(i);
            }
        }
        return null;
    }

    /**
     * The setSections(List<Section> sections) operation sets the sections.
     */
    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    /**
     * The addSection(Section section) operation adds a section.
     * @param section
     */
    public void addSection(Section section){
        sections.add(section);
    }

    /**
     * The removeSection(String sectionNo) operation removes a section.
     * @return true if section is removed, false otherwise.
     */
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

    /**
     * The getCoursesTaken() operation gets the courses taken by a student.
     * @return the courses taken by a student.
     */
    public List<Course> getCoursesTaken() {
        return coursesTaken;
    }

    /**
     * The setCourses(List<Course> coursesTaken) operation sets the courses taken by a student.
     * @param coursesTaken
     */
    public void setCourses(List<Course> coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    /**
     * The getcourse(String courseCode) operation gets the course with its course code.
     * @return the course if operation is successful, null otherwise.
     */
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

    /**
     * The addCourse(Course course) operation adds a course.
     */
    public void addCourse(Course course){
       coursesTaken.add(course);
    }

    /**
     * The removeCourse(String courseCode) operation removes a course.
     * @return true if remove operation is successful, false otherwise.
     */
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

    /**
     * The addRoomToHistory(VisitedRoom room) operation adds a room to the history.
     */
    public void addRoomToHistory(VisitedRoom room) {
        dailyRooms.add(room);
    }

    /**
     * The submitRoomHistory() submits a room history.
     */
    public void submitRoomHistory() {
        prizePoints = prizePoints + 10;
        roomHistory.addAll(dailyRooms);
        dailyRooms.clear();
    }

    //Seat op

    /**
     * The swapRequestExists(int requestCode) checks if a given swap request exists or not.
     * @return true if swap request exists, false otherwise.
     */
    public boolean swapRequestExists(int requestCode){
        for (int i = 0; i < swapRequests.size(); i++)  {
            if (swapRequests.get(i).getNotificationCode() == requestCode)
                return true;
        }
        return false;
    }

    /**
     * The getSwapRequest(int code) operation gets a swap request with its code.
     * @return the code if operation is successful, false otherwise.
     */
    public SwapRequest getSwapRequest(int code) {
        for (int i = 0; i < swapRequests.size(); i++) {
            if (swapRequests.get(i).getNotificationCode() == code) {
                return swapRequests.get(i);
            }
        }
        return null;
    }

    /**
     * The bothHaveSeats(Student sender, Student receiver, Section section) operation checks if bpth students have a
     * proper seat in order to be swapped.
     * @return true if both students have seats, false otherwise.
     */
    public boolean bothHaveSeats(Student sender, Student receiver, Section section){
        if ( sender != null && receiver != null && section != null  &&
                section.getSeatingPlan().hasSeat(sender) && section.getSeatingPlan().hasSeat(receiver))
            return true;
        else
            return false;
    }

    /**
     * The addSwapRequest(SwapRequest sR) operation adds a swap request to the list.
     */
    public void addSwapRequest(SwapRequest sR){
        swapRequests.add(sR);
    }

    /**
     * The getSwapRequests() operation gets all the swap requests.
     * @return the swap requests list.
     */
    public List<SwapRequest> getSwapRequests(){
        return swapRequests;
    }

    /**
     * The selectSeat(String seatNum, String sectionCode) operation selects the seat.
     * @return the result if operation is successful, false otherwise.
     */
    public boolean selectSeat(String seatNum, String sectionCode){
        for (int i = 0; i < sections.size(); i++){
            if (Objects.equals(sections.get(i).getSectionNo(), sectionCode)){
                boolean result = sections.get(i).getSeatingPlan().selectSeat(seatNum, this);
                return result;
            }
        }
        return false;
    }

    /**
     * The createSwapRequest(String seatNo, String courseSection) operation creates a swap request.
     */
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

    /**
     * The cancelSwapRequest(int requestCode) operation cancels a swap request made by the requester.
     * @return true if canceling is successful, false otherwise.
     */
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

    /**
     * The rejectSwapRequest(int requestCode) operation rejects a swap request.
     */
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

    /**
     * The acceptSwapRequest(int requestCode) operation accepts a swap request.
     */
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

    /**
     * The rejectAllSwapRequests() operation rejects all swap requests.
     */
    public void rejectAllSwapRequest() {
        for (int i = 0; i < swapRequests.size(); i++) {
            swapRequests.get(i).markAsRejected();
        }
    }

    // FACADE OPERATIONS
    public boolean selectSeatByFacade(String seatNum, String sectionCode){
        return sectionFacade.selectSeat(seatNum, sectionCode, sections, this);
    }


    public void createSwapRequestByFacade(String seatNo, String courseSection) {
        sectionFacade.createSwapRequest(this, seatNo, sections, courseSection, swapRequests);
    }

    public boolean cancelSwapRequestByFacade(int requestCode) {
        return sectionFacade.cancelSwapRequest(requestCode, swapRequests);
    }

    // Important: This will be done by owner/receiver
    public void rejectSwapRequestByFacade(int requestCode) {
        sectionFacade.rejectSwapRequest(swapRequests, requestCode);
    }

    // Important: This will be done by owner/receiver
    public void acceptSwapRequestByFacade(int requestCode) {
        sectionFacade.acceptSwapRequest(swapRequests, requestCode, sections);
    }
}
