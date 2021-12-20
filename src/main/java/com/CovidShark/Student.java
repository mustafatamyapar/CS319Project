package main.java.com.CovidShark;

import java.util.List;

public class Student extends BaseUser {
    private String about;
    private List<Course> coursesTaken;
    private Dormitory dorm;
    private Form form;
    private List<VisitedRoom> roomHistory;
    private int formSymptomNumber;
    private List<Section> sections;
    private List<String> seats;
    private List<SwapRequest> swapRequests;
    private int prizePoint;

    public Student(String about, List<Course> coursesTaken, Dormitory dorm, Form form, List<VisitedRoom> roomHistory,
                   int formSymptomNumber, List<Section> sections, List<String> seats, List<SwapRequest> swapRequests,
                   int prizePoint) {

        super();
        this.about = about;
        this.coursesTaken = coursesTaken;
        this.dorm = dorm;
        this.form = form;
        this.roomHistory = roomHistory;
        this.formSymptomNumber = formSymptomNumber;
        this.sections = sections;
        this.seats = seats;
        this.swapRequests = swapRequests;
        this.prizePoint = prizePoint;
    }

    public String getAbout() {

        return about;
    }


    public List<Course> getCoursesTaken() {

        return coursesTaken;
    }

    public boolean isStudentInDorm() {

        return dorm == null;
    }

    public Form getForm() {

        return form;
    }

    public void updateFormSymptoms() {
        
    }

    public int getDorm(int dormNumber) {

        return dormNumber;
    }

    public List<Section> getSections() {

        return sections;
    }

    public List<String> getSeats() {

        return seats;
    }

    public String getCourse(String courseCode) {

        return courseCode;
    }

    public void cancelSwapRequest(int requestCode) {

        swapRequests.remove(requestCode);
    }

    public List<SwapRequest> createSwapRequest(String seatNo, String courseCode, String courseSection,
                                               Student requester) {

        SwapRequest request = new SwapRequest();
        swapRequests.add(request);
        return (List<SwapRequest>) request;
    }

    public void rejectSwapRequest(int requestCode) {

        swapRequests.remove(requestCode);
    }

    public void acceptSwapRequest(int requestCode) {

        //swapRequests.add(requestCode);
    }

    public void rejectAllSwapRequest() {

        swapRequests.clear();
    }

    public int getPrizePoint() {

        return prizePoint;
    }

    public void addRoomToHistory(VisitedRoom room) {

        roomHistory.add(room);
    }

    public void submitRoomHistory() {

    }

    public void submitForm() {

    }
}
