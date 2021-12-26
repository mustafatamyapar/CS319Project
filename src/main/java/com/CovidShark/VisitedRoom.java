package com.CovidShark;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The VisitedRoom class.
 */
public class VisitedRoom {

    /**
     * The building String holds a building.
     */
    private String building;

    /**
     * The floor integer holds a floor number.
     */
    private int floor;

    /**
     * The roomName String holds a room name.
     */
    private String roomName;

    /**
     * The usedHours String holds the used hours.
     */
    private String usedHours;

    /**
     * The date String holds the date.
     */
    private String date;

    public VisitedRoom(String building, int floor, String roomName, String usedHours) {
        this.building = building;
        this.floor = floor;
        this.roomName = roomName;
        this.usedHours = usedHours;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        date = formatter.format(new Date());
    }

    /**
     * The getDate() operation gets the date.
     * @return the date.
     */
    public String getDate() {
        return date;
    }

    /**
     * The getBuilding() operation gets the building.
     * @return the building.
     */
    public String getBuilding() {
        return building;
    }

    /**
     * The setBuilding(String building) operation sets the building.
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     *  The getFloor() operation gets the floor.
     * @return the floor number.
     */
    public int getFloor() {
        return floor;
    }

    /**
     * The setFloor(int floor) operation sets the floor.
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * The getRoomName() operation gets the room name.
     * @return the room name.
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * The setRoomName(String roomName) operation sets the room name.
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * The getUsedHours() operation gets the used hours.
     * @return the used hours.
     */
    public String getUsedHours() {
        return usedHours;
    }

    /**
     * The setUsedHours(String usedHours) operation sets the used hours.
     */
    public void setUsedHours(String usedHours) {
        this.usedHours = usedHours;
    }
}
