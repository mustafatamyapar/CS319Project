package com.CovidShark;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Floor class.
 */
public class Floor {
    /**
     * The dormNumber integer holds the dorm number.
     */
    private int dormNumber;

    /**
     * The floorNumber integer holds the floor number.
     */
    private int floorNumber;

    // either the student is staying on the floor or selected the floor as used.
    /**
     * The studentsInFloor is a student list which holds the students.
     */
    private List<Student> studentsInFloor;


    public Floor(int dormNumber, int floorNumber) {
        this.dormNumber = dormNumber;
        this.floorNumber = floorNumber;
        this.studentsInFloor = new ArrayList<>();
    }

    /**
     * The getFloorNumber() operation gets the floor number.
     * @return the floor number.
     */
    public int getFloorNumber() {
        return floorNumber;
    }

    /**
     * The getDormNumber() operation gets the dorm number.
     * @return the dorm number.
     */
    public int getDormNumber(){return dormNumber;}

    /**
     * The getNumberOfInfectedInFloor() operation gets the number of students who are infected in a floor.
     * @return the number of infected students in a floor.
     * @pre covidCount = 0
     * @post covidCount = @pre.covidCount + 1;
     */
    public int getNumberOfInfectedInFloor() {
        int covidCount = 0;
        for (int i = 0; i < studentsInFloor.size(); i++) {
            if (studentsInFloor.get(i).getHealthStatus().isCovid()) {
                covidCount++;
            }
        }
        return covidCount;
    }

    /**
     * The addStudentToFloor(Student s) operation add a student to a floor in a dorm.
     */
    public void addStudentToFloor(Student s) {
        studentsInFloor.add(s);
    }

    /**
     * The removeStudentFromFloor(String idNumber) operation removes a student from a floor in a dorm.
     */
    public void removeStudentFromFloor(String idNumber) {
        for (int i = 0; i < studentsInFloor.size(); i++) {
            if (Objects.equals(studentsInFloor.get(i).getIdNumber(), idNumber))
                studentsInFloor.remove(i);
        }
    }
}
