package com.CovidShark;

import java.util.List;

public class Dormitory {

    private int dormNumber;
    private List<Floor> floors;
    private int noOfFloor;
    private List<Student> students;
    private int floorCovidCount;

    public Dormitory(int dormNumber, List<Floor> floors, int noOfFloor, List<Student> students) {
        this.dormNumber = dormNumber;
        this.floors = floors;
        this.noOfFloor = noOfFloor;
        this.students = students;
        this.floorCovidCount = 0;
    }

    public int getFloorCovidInfo(int floorNumber) {
        for (int i = 0; i < floors.size(); i++) {
            if (floors.get(i).getFloorNumber() == floorNumber) {
                floorCovidCount = floors.get(i).getNumberOfInfectedInFloor();
            }
        }
        return floorCovidCount;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(String idNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getIdNumber() == idNumber)
                students.remove(i);
        }
    }
}

