package com.CovidShark;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends BaseUser {
    private List<Course> coursesGiven;
    private List<Section> sectionsGiven;

    public Instructor(String idNumber, String name, String email, String phoneNumber, List<Course> coursesGiven) {
        super(idNumber, name, email, phoneNumber);
        this.coursesGiven = new ArrayList<Course>();
        this.sectionsGiven = new ArrayList<Section>();
    }

    public List<Course> getCoursesList() {
        return coursesGiven;
    }

    public List<Student> seeInfectedInClassroom(Course course, int sectionNo) {
        List<Student> infected = new ArrayList<Student>();
        for (int i = 0; i < coursesGiven.size(); i++) {
            if (coursesGiven.get(i).getHealthStatus().isCovid()) {
                infected.add(coursesGiven.get(i));
            }
        }
        return infected;
    }

    public Section addGivenSection() {
        Section s = new Section();
    }

    public Course addGivenCourse() {

    }
}
