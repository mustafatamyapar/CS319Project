package com.CovidShark;

import java.util.List;
import java.util.Objects;

/**
 * The Course class.
 */
public class Course {

    /**
     * The courseName String holds the name of a specific course.
     */
    private String courseName;

    /**
     * The courseCode String holds the code of a specific course (For example: MATH101).
     */
    private String courseCode;

    /**
     * The courseSections list holds the section objects.
     */
    private List<Section> courseSections;

    /**
     * The courseCoordinator object holds the instructor.
     */
    private Instructor courseCoordinator;

    public Course(String courseName, String courseCode, List<Section> courseSections, Instructor courseCoordinator) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseSections = courseSections;
        this.courseCoordinator = courseCoordinator;
    }

    public Course(){

    }

    public void initializeC(String courseName, String courseCode, List<Section> courseSections, Instructor courseCoordinator){
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseSections = courseSections;
        this.courseCoordinator = courseCoordinator;
    }

    /**
     * The getCourseCoordinator() operation gets the coordinator of a course.
     * @return the coordinator of the course.
     */
    public Instructor getCourseCoordinator() {
        return courseCoordinator;
    }

    /**
     * The setCourseCoordinator(Instructor courseCoordinator) operation sets the coordinator of a course.
     */
    public void setCourseCoordinator(Instructor courseCoordinator) {
        this.courseCoordinator = courseCoordinator;
    }

    // No setter methods since those cannot be changed after they are declared.

    /**
     * The getCourseCode() operation gets the code of a specific course.
     * @return the course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * The getCourseName() operation gets the name of a specific course.
     * @return the course name.
     */
    public String getCourseName() {
        return courseName;
    }

    // Section operations

    /**
     * The getSection(String sectionNo) operation gets the section of a course with the section number.
     * @return the section if the operation is successful, null otherwise.
     */
    public Section getSection(String sectionNo) {
        for (int i = 0; i < courseSections.size(); i++) {
            if (Objects.equals(courseSections.get(i).getSectionNo(), sectionNo)) {
                return courseSections.get(i);
            }
        }
        return null;
    }

    /**
     * The getCourseSections() operation gets all the sections of a specific course.
     * @return the sections of a course (For example: section 1, 2, and 3 of CS319).
     */
    public List<Section> getCourseSections() {
        return courseSections;
    }

    /**
     * The addSection(Section section) operation adds a section to the course sections list.
     * @return false if the operation is unsuccessful, true otherwise.
     */
    public boolean addSection(Section section) {
        for (int i = 0; i < courseSections.size(); i++) {
            if (Objects.equals(courseSections.get(i).getSectionNo(), section.getSectionNo())) {
                return false;
            }
        }
        courseSections.add(section);
        return true;
    }

    /**
     * The removeSection(String sectionNo) operation removes a section from the course sections list.
     * @return true if remove operation is successful, false otherwise.
     */
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
