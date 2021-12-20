package com.CovidShark;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

public class Section {

    private String sectionNo;
    private Instructor instructor;
    private int numberOfEnrolledStudents;
    private int quota;
    private SeatingPlan seatingPlan;
    private String room;
    private List<String> allLectureHours;
    private List<Student> enrolledStudents;

    public Section(String sectionNo, Instructor instructor, int numberOfEnrolledStudents, int quota,
                   SeatingPlan seatingPlan, String room, List<String> allLectureHours,
                   List<Student> enrolledStudents) {

        this.sectionNo = sectionNo;
        this.instructor = instructor;
        this.numberOfEnrolledStudents = numberOfEnrolledStudents;
        this.quota = quota;
        this.seatingPlan = seatingPlan;
        this.room = room;
        this.allLectureHours = allLectureHours;
        this.enrolledStudents = enrolledStudents;
    }

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
        List<Student> infected = new ArrayList<Student>();
        for (int i = 0; i < enrolledStudents.size(); i++) {
            if (enrolledStudents.get(i).getHealthStatus().isCovid()) {
                infected.add(enrolledStudents.get(i));
            }
        }
        return infected;
    }

    public SeatingPlan getSeatingPlan() {
        return seatingPlan;
    }
}
