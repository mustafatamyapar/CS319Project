package com.CovidShark;

import java.util.List;

public class Floor {

    private int floorNumber;
    private List<Student> studentsInFloor;
    private int covidCount;

    public Floor(int floorNumber, List<Student> studentsInFloor) {
        this.floorNumber = floorNumber;
        this.studentsInFloor = studentsInFloor;
        this.covidCount = 0;
    }

    public int getNumberOfInfectedInFloor() {
        for (int i = 0; i < studentsInFloor.size(); i++) {
            if (studentsInFloor.get(i).getHealthStatus().isCovid()) {
                covidCount++;
            }
        }
        return covidCount;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void addStudent(Student s) {
        studentsInFloor.add(s);
    }

    public void removeStudent(String idNumber) {
        for (int i = 0; i < studentsInFloor.size(); i++) {
            if (studentsInFloor.get(i).getIdNumber() == idNumber)
                studentsInFloor.remove(i);
        }
    }
}
