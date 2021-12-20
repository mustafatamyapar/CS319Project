package com.CovidShark;

import java.util.ArrayList;
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
    private String idNumber;
    private String name;
    private String email;
    private String password;
    private HealthStatus healthStatus;
    private List<Notification> notifications;
    private String phoneNumber;
    private List<Appointment> appointments;
    private Appointment appointment;


    public Student(String idNumber, String name, String email, String phoneNumber, String about,
                   List<Course> coursesTaken, List<Section> sections, List<SwapRequest> swapRequests) {

        super(idNumber, name, email, phoneNumber);
        this.about = about;
        this.coursesTaken = coursesTaken;
        dorm = null;
        form = null;
        roomHistory = null;
        formSymptomNumber = 0;
        this.sections = sections;
        seats = null;
        this.swapRequests = new ArrayList<SwapRequest>();
        prizePoint = 0;
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

    public SwapRequest createSwapRequest(String seatNo, String courseSection,
                                               Student requester) {

        Section currentSec = getSection(courseSection);
        Student s = currentSec.getSeatingPlan().getStudent(seatNo);
        SwapRequest request = new SwapRequest(seatNo, s, requester, currentSec);
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
        return prizePoint;
    }

    public void addRoomToHistory(VisitedRoom room) {
        roomHistory.add(room);
    }

    public void submitRoomHistory() {
        prizePoint = prizePoint + 10;
    }

    public void submitForm() {
        prizePoint = prizePoint + 5;
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
