package com.CovidShark;

import java.util.List;

public class Course {

    private String courseName;
    private String courseCode;
    private List<Section> courseSections;
    private Instructor courseCoordinator;

    public Instructor getCourseCoordinator() {
        return courseCoordinator;
    }

    public List<Section> getCourseSections() {
        return courseSections;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public Section getSection(String sectionNo) {
        Section sec = null;
        for (int i = 0; i < courseSections.size(); i++) {
            if (courseSections.get(i).getSectionNo() == sectionNo) {
                sec = courseSections.get(i);
            }
        }
        return sec;
    }
}
