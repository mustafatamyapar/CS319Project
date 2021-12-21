package com.CovidShark;

import java.util.List;

public class Dormitory {

    private int dormNumber;
    private List<Floor> floors;
    private int noOfFloor;
    private List<Student> students;
    private int floorCovidCount;

    public int getFloorCovidInfo(int floorNumber) {
        for (int i = 0; i < floors.size(); i++) {
            if (floors.get(i).getFloorNumber() == floorNumber) {
                floorCovidCount = floors.get(i).getNumberOfInfectedInFloor();
            }
        }
        return floorCovidCount;
    }

    /*
    public List<Student> getStudents(int dormNumber) {

    }
    */
}
