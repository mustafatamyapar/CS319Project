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

    public List<Student> seeInfectedInClassroom(Course course, String sectionNo) {

        List<Student> infected;
        infected = course.getSection(sectionNo).seeInfectedInSection();
        return infected;
    }

  //  public Section addGivenSection() {
  //      Section s = new Section();
  //      return s;
  //  }

  //  public Course addGivenCourse() {
  //
  //  }
}
