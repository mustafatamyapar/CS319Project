package com.CovidShark;

import java.util.List;

public class Floor {

    private int floorNumber;
    private List<Student> studentsInFloor;
    private int covidCount = 0;

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
}
