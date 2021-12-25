package com.CovidShark;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Dormitory class.
 */
public class Dormitory {

    /**
     * The dormNumber integer holds the number of a dorm (For example: 81st dorm).
     */
    private int dormNumber;

    /**
     * The floors list holds the floor objects of a dorm. (For example: All 11 floors of 81st dorm).
     */
    private List<Floor> floors;

    /**
     * The noOfFloor integer holds the floor number of a dorm.
     */
    private int noOfFloor;

    /**
     * The students list holds a list of student objects.
     */
    private List<Student> students;

    /**
     * The floorCovidCount integer holds the covid positive student number in a dorm.
     */
    private int floorCovidCount;

    public Dormitory(int dormNumber, List<Floor> floors, int noOfFloor) {
        this.dormNumber = dormNumber;
        this.noOfFloor = noOfFloor;
        this.floors = floors;
        this.students = new ArrayList<Student>();
        this.floorCovidCount = 0;
    }

    /**
     * The getDormNumber() operation gets the dorm number.
     * @return the dorm number.
     */
    public int getDormNumber() {
        return dormNumber;
    }

    /**
     * The getNoOfFloor() operation gets the number of a specific floor in a dorm.
     * @return the number of the floor.
     */
    public int getNoOfFloor() {return noOfFloor;}

    /**
     * The getFloorCovidInfo(int floorNumber) operation gets the covid information of a specific floor in a dorm.
     * @return the covid information of a floor if floorNumber is less than or equal to the number of floor, 0 otherwise.
     */
    public int getFloorCovidInfo(int floorNumber) {
        if (floorNumber <= noOfFloor) {
                return floors.get(floorNumber).getNumberOfInfectedInFloor();
        }
        else
            return 0;
    }

    /**
     * The getStudents() operation gets the students.
     * @return the list of student objects.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * The registerStudentToDorm(Student s, int floorNum) operation registers a student to a dorm.
     * @return false if the student already exists in the dorm, registers the student and returns true otherwise.
     */
    public boolean registerStudentToDorm(Student s, int floorNum) {
        for (int i = 0; i < students.size(); i++){
            // already exists in the dorm
            if (Objects.equals(students.get(i).getIdNumber(), s.getIdNumber())) {
                return false;
            }
        }
        s.setDorm(this);
        //1) main registration to the dorm
        students.add(s);
        //2) we also need to make separate addition to floor so that floor info can be obtained afterwards
        floors.get(floorNum).addStudentToFloor(s);
        return true;
    }

    /**
     * The removeStudentFromDorm(String idNumber) operation removes a student from the dorm.
     * @return true if the student is removed from the dorm, false otherwise.
     */
    public boolean removeStudentFromDorm(String idNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (Objects.equals(students.get(i).getIdNumber(), idNumber)) {
                students.get(i).setDorm(null);
                // remove from both dorm and floor separately
                students.remove(i);
                floors.get(i).removeStudentFromFloor(idNumber);
                return true;
            }
        }
        return false;
    }

    /**
     * The getFloor(int floorNum) operation gets the floor object with the floor number.
     * @return the floor if floorNum <= noOfFloor, null otherwise
     */
    public Floor getFloor(int floorNum){
        if (floorNum <= noOfFloor) {
            return floors.get(floorNum);
        }
        else
            return null;
    }
}

