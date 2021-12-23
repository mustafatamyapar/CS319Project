package com.CovidShark;

import java.util.ArrayList;
import java.util.List;



public class Student extends BaseUser {

    private String about;
    private int formSymptomNumber;
    private int prizePoints;

    private Dormitory dorm;
    private Form form;

    private List<Course> coursesTaken;
    private List<Section> sections;
    private List<VisitedRoom> roomHistory;
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
        roomHistory = null;

        swapRequests = new ArrayList<SwapRequest>();
        //seats = null;

    }

    // basic operations
    public String getAbout() {
        return about;
    }
    public void setAbout(String aboutMeDescription) {
        about = aboutMeDescription;
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
            formSymptomNumber = formSymptomNumber + form.getSymptomNumber();
            prizePoints = prizePoints + 5;
            form.resetForm();
            return true;
        }
        return false;
    }

    // resetting formSymptomNumber to zero after 5 days
    // request pcr test after ... days











    // dorm operations
    // section op
    // course op
    // room history op
    public void setDorm(Dormitory dorm){
        this.dorm = dorm;
    }
    public Dormitory getDorm(int dormNumber) {
        return dorm;
    }


    public List<Course> getCoursesTaken() {
        return coursesTaken;
    }

    public boolean isStudentInDorm() {
        return dorm == null;
    }





    public List<Section> getSections() {
        return sections;
    }


    public String getCourse(String courseCode) {
        return courseCode;
    }

    public void cancelSwapRequest(int requestCode) {
        swapRequests.remove(requestCode);
    }

    public SwapRequest createSwapRequest(String seatNo, String courseSection,
                                               Student requester) {

        Section currentSec = getSection(courseSection);
        Student s = currentSec.getSeatingPlan().getStudent(seatNo);
        SwapRequest request = new SwapRequest(seatNo, s, this, currentSec);
        swapRequests.add(request);
        return request;
    }

    public Section getSection(String courseSection) {
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionNo().equals(courseSection)) {
                return sections.get(i);
            }
        }
        return null;
    }

    public void rejectSwapRequest(int requestCode) {
        getSwapRequest(requestCode).markAsRejected();
    }

    public void acceptSwapRequest(int requestCode) {
        SwapRequest sr = getSwapRequest(requestCode);
        Section currSec = sr.getSection();
        currSec.getSeatingPlan().swapSeats(sr.getRequester(), sr.getSeatOwner());
        sr.markAsDone();
    }

    public void rejectAllSwapRequest() {
        for (int i = 0; i < swapRequests.size(); i++) {
            swapRequests.get(i).markAsRejected();
        }
        swapRequests.clear();
    }

    public int getPrizePoint() {
        return prizePoints;
    }

    public void addRoomToHistory(VisitedRoom room) {
        roomHistory.add(room);
    }

    public void submitRoomHistory() {
        prizePoints = prizePoints + 10;
    }



    public SwapRequest getSwapRequest(int code) {
        for (int i = 0; i < swapRequests.size(); i++) {
            if (swapRequests.get(i).getNotificationCode() == code) {
                return swapRequests.get(i);
            }
        }
        return null;
    }
}
