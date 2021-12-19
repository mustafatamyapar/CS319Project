package main.java.com.CovidShark;

import java.util.List;

public class Instructor extends BaseUser {
    private List<Course> coursesGiven;

    public List<Course> getCoursesList() {
        return coursesGiven;
    }

    public List<Student> seeInfectedInClassroom(Course course, int sectionNo) {

    }
}
