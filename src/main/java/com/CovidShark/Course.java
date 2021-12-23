package com.CovidShark;

import java.util.List;
import java.util.Objects;

public class Course {

    private String courseName;
    private String courseCode;
    private List<Section> courseSections;
    private Instructor courseCoordinator;

    public Course(String courseName, String courseCode, List<Section> courseSections, Instructor courseCoordinator) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseSections = courseSections;
        this.courseCoordinator = courseCoordinator;
    }

    public Instructor getCourseCoordinator() {
        return courseCoordinator;
    }
    public void setCourseCoordinator(Instructor courseCoordinator) {
        this.courseCoordinator = courseCoordinator;
    }

    // No setter methods since those cannot be changed after crreation!!!
    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseName() {
        return courseName;
    }

    // Section operations
    public Section getSection(String sectionNo) {
        for (int i = 0; i < courseSections.size(); i++) {
            if (Objects.equals(courseSections.get(i).getSectionNo(), sectionNo)) {
                return courseSections.get(i);
            }
        }
        return null;
    }

    public List<Section> getCourseSections() {
        return courseSections;
    }


    public boolean addSection(Section section) {
        for (int i = 0; i < courseSections.size(); i++) {
            if (Objects.equals(courseSections.get(i).getSectionNo(), section.getSectionNo())) {
                return false;
            }
        }
        courseSections.add(section);
        return true;
    }

    public boolean removeSection(String sectionNo){
        for (int i = 0; i < courseSections.size(); i++) {
            if (Objects.equals(courseSections.get(i).getSectionNo(), sectionNo)) {
                courseSections.remove(i);
                return true;
            }
        }
        return false;
    }


}
