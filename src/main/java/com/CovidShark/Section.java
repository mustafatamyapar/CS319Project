package com.CovidShark;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

/**
 * The Section class.
 */
public class Section {

    /**
     * The sectionNo String holds the section number.
     */
    private String sectionNo;

    /**
     * The instructor object holds an instructor.
     */
    private Instructor instructor;

    /**
     * The numberOfEnrolledStudents integer holds the number of enrolled students.
     */
    private int numberOfEnrolledStudents;

    /**
     * The quota integer holds the quota of a lesson.
     */
    private int quota;

    /**
     * The seatingPlan object holds the seating plan.
     */
    private SeatingPlan seatingPlan;

    /**
     * The room String holds the room.
     */
    private String room;

    /**
     * The allLectureHours String list holds all the lecture hours.
     */
    private List<String> allLectureHours;

    /**
     * The enrolledStudents Student list holds the enrolled students.
     */
    private List<Student> enrolledStudents;

    public Section(String sectionNo, Instructor instructor, int numberOfEnrolledStudents, int quota,
                   SeatingPlan seatingPlan, String room, List<String> allLectureHours) {

        this.sectionNo = sectionNo;
        this.instructor = instructor;
        this.numberOfEnrolledStudents = numberOfEnrolledStudents;
        this.quota = quota;
        this.seatingPlan = seatingPlan;
        this.room = room;
        this.allLectureHours = allLectureHours;
        this.enrolledStudents = new ArrayList<Student>();
    }

    /**
     * The getSectionNo() operation gets the section number of a section.
     * @return the section number.
     */
    public String getSectionNo() {
        return sectionNo;
    }

    /**
     * The getInstructor() operation gets the instructor of a section.
     * @return the instructor.
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * The getRoom() operation gets the room of a course.
     * @return the room.
     */
    public String getRoom() {
        return room;
    }

    /**
     * The getAllLectureHours() operation gets all the lecture hours.
     * @return the lecture hours.
     */
    public List<String> getAllLectureHours() {
        return allLectureHours;
    }

    /**
     * The getStudentsInSection() operation gets the students in a section.
     * @return the students in a section.
     */
    public List<Student> getStudentsInSection() {
        return enrolledStudents;
    }

    /**
     * The seeInfectedInSection() operation sees the infected students in a section.
     * @return the infected students in section.
     */
    public List<Student> seeInfectedInSection() {
        List<Student> infected = new ArrayList<Student>();
        for (int i = 0; i < enrolledStudents.size(); i++) {
            if (enrolledStudents.get(i).getHealthStatus().isCovid()) {
                infected.add(enrolledStudents.get(i));
            }
        }
        return infected;
    }

    /**
     * The getSeatingPlan() operation gets the seating plan of a section.
     * @return the seating plan.
     */
    public SeatingPlan getSeatingPlan() {
        return seatingPlan;
    }
}
