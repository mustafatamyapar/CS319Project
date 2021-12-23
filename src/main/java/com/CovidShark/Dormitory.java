package com.CovidShark;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dormitory {

    private int dormNumber;
    private List<Floor> floors;
    private int noOfFloor;
    private List<Student> students;
    private int floorCovidCount;

    public Dormitory(int dormNumber, List<Floor> floors, int noOfFloor) {
        this.dormNumber = dormNumber;
        this.noOfFloor = noOfFloor;
        this.floors = floors;
        this.students = new ArrayList<Student>();
        this.floorCovidCount = 0;
    }

    public int getDormNumber() {
        return dormNumber;
    }
    public int getNoOfFloor() {return noOfFloor;}

    public int getFloorCovidInfo(int floorNumber) {
        if (floorNumber <= noOfFloor) {
                return floors.get(floorNumber).getNumberOfInfectedInFloor();
        }
        else
            return 0;
    }

    public List<Student> getStudents() {
        return students;
    }

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

    public Floor getFloor(int floorNum){
        if (floorNum <= noOfFloor) {
            return floors.get(floorNum);
        }
        else
            return null;
    }


}

