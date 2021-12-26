package com.CovidShark;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Instructor class extends the BaseUser class.
 */
public class Instructor extends BaseUser {

    /**
     * The coursesGiven list holds the courses.
     */
    private List<Course> coursesGiven;

    /**
     * The sectionsGiven list holds the sections.
     */
    private List<Section> sectionsGiven;

    public Instructor(String idNumber, String name, String email, String phoneNumber) {

        super(idNumber, name, email, phoneNumber);
        this.coursesGiven = new ArrayList<Course>();
        this.sectionsGiven = new ArrayList<Section>();
    }

    public Instructor(){

    }

    public void initIns(String idNumber, String name, String email, String phoneNumber){
        this.setIdNumber(idNumber);
        this.setName(name);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.coursesGiven = new ArrayList<Course>();
        this.sectionsGiven = new ArrayList<Section>();
    }

    /**
     * The getCoursesGiven() operation gets the courses given by an instructor.
     * @return the list of courses given.
     */
    public List<Course> getCoursesGiven() {
        return coursesGiven;
    }

    /**
     * The addCourse(Course courseGiven) operation adds a course to the courses given list.
     */
    public void addCourse(Course courseGiven) {
        coursesGiven.add(courseGiven);
    }

    /**
     * The setSectionsGiven(Section sectionsGiven) operation sets the sections given by an instructor.
     */
    public void setSectionsGiven(Section sectionGiven) {
        sectionsGiven.add(sectionGiven);
    }

    /**
     * The getSectionsGiven() operation gets the sections given by an instructor.
     * @return the sections given.
     */
    public List<Section> getSectionsGiven() {
        return sectionsGiven;
    }

    /**
     * The seeInfectedInClassroom(String sectionNo) operation sees the infected students in a classroom.
     * @return the infected students list if the given section exists, null otherwise
     */
    public List<Student> seeInfectedInClassroom(String sectionNo) {

        if (sectionExists(sectionNo)){
            for (int i = 0; i < sectionsGiven.size(); i++){
                if (Objects.equals(sectionsGiven.get(i).getSectionNo(), sectionNo))
                    return sectionsGiven.get(i).seeInfectedInSection();
            }
        }
        return null;
    }

    /**
     * The sectionExists(String sectionNo) operation checks if a section exists or not.
     * @return true if section exists, false otherwise.
     */
    public boolean sectionExists(String sectionNo){
        for (int i = 0; i < sectionsGiven.size(); i++){
            if (Objects.equals(sectionsGiven.get(i).getSectionNo(), sectionNo))
                return true;
        }
        return false;
    }
}
