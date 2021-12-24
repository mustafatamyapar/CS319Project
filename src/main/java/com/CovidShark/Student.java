package com.CovidShark;

import com.google.common.collect.EvictingQueue;

import java.util.ArrayList;
import java.util.List;



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

    //Swap op
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





    public SwapRequest getSwapRequest(int code) {
        for (int i = 0; i < swapRequests.size(); i++) {
            if (swapRequests.get(i).getNotificationCode() == code) {
                return swapRequests.get(i);
            }
        }
        return null;
    }
}
