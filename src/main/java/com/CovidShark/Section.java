package main.java.com.CovidShark;

import java.util.List;

public class Section {

    private String sectionNo;
    private Instructor instructor;
    private int numberOfEnrolledStudents;
    private int quota;
    private SeatingPlan seatingPlan;
    private String room;
    private List<String> allLectureHours;
    private List<Student> enrolledStudents;

    public String getSectionNo() {
        return sectionNo;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public String getRoom() {
        return room;
    }

    public List<String> getAllLectureHours() {
        return allLectureHours;
    }

    public List<Student> getStudentsInSection() {
        return enrolledStudents;
    }

    public List<Student> seeInfectedInSection() {

    }
}
