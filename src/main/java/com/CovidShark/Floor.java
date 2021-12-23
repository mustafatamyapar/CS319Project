package com.CovidShark;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Floor {
    private int dormNumber;
    private int floorNumber;

    // either staying on the floor or selected the dorm as used!!!
    private List<Student> studentsInFloor;

    //private int covidCount;

    public Floor(int dormNumber, int floorNumber) {
        this.dormNumber = dormNumber;
        this.floorNumber = floorNumber;
        this.studentsInFloor = new ArrayList<Student>();
        //this.covidCount = 0;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
    public int getDormNumber(){return dormNumber;}

    public int getNumberOfInfectedInFloor() {
        int covidCount = 0;
        for (int i = 0; i < studentsInFloor.size(); i++) {
            if (studentsInFloor.get(i).getHealthStatus().isCovid()) {
                covidCount++;
            }
        }
        return covidCount;
    }


    public void addStudentToFloor(Student s) {
        studentsInFloor.add(s);
    }

    public void removeStudentFromFloor(String idNumber) {
        for (int i = 0; i < studentsInFloor.size(); i++) {
            if (Objects.equals(studentsInFloor.get(i).getIdNumber(), idNumber))
                studentsInFloor.remove(i);
        }
    }
}
