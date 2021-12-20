package com.CovidShark;

public class VisitedRoom {

    private String building;
    private int floor;
    private String roomName;
    private String usedHours;

    public VisitedRoom(String building, int floor, String roomName, String usedHours) {
        this.building = building;
        this.floor = floor;
        this.roomName = roomName;
        this.usedHours = usedHours;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getUsedHours() {
        return usedHours;
    }

    public void setUsedHours(String usedHours) {
        this.usedHours = usedHours;
    }
}
