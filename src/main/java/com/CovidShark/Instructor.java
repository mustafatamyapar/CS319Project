package com.CovidShark;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Instructor extends BaseUser {
    private List<Course> coursesGiven;
    private List<Section> sectionsGiven;

    public Instructor(String idNumber, String name, String email, String phoneNumber) {
        super(idNumber, name, email, phoneNumber);
        this.coursesGiven = new ArrayList<Course>();
        this.sectionsGiven = new ArrayList<Section>();
    }

    public List<Course> getCoursesGiven() {
        return coursesGiven;
    }

    public void addCourse(Course courseGiven) {
        coursesGiven.add(courseGiven);
    }

    public void setSectionsGiven(Section sectionGiven) {
        sectionsGiven.add(sectionGiven);
    }

    public List<Section> getSectionsGiven() {
        return sectionsGiven;
    }

    public List<Student> seeInfectedInClassroom(String sectionNo) {

        if (sectionExists(sectionNo)){
            for (int i = 0; i < sectionsGiven.size(); i++){
                if (Objects.equals(sectionsGiven.get(i).getSectionNo(), sectionNo))
                    return sectionsGiven.get(i).seeInfectedInSection();
            }
        }
        return null;
    }



    public boolean sectionExists(String sectionNo){
        for (int i = 0; i < sectionsGiven.size(); i++){
            if (Objects.equals(sectionsGiven.get(i).getSectionNo(), sectionNo))
                return true;
        }
        return false;
    }


}
