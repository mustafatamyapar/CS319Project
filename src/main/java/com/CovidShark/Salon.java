package com.CovidShark;

import java.util.Date;

public class Salon {

    private String salonType;
    private Date lastUsedTime;
    private int numberOfCurrentUsers;
    private int salonCapacity;

    public Salon(String salonType, Date lastUsedTime, int numberOfCurrentUsers, int salonCapacity) {
        this.salonType = salonType;
        this.lastUsedTime = lastUsedTime;
        this.numberOfCurrentUsers = numberOfCurrentUsers;
        this.salonCapacity = salonCapacity;
    }

    public String getSalonType() {
        return salonType;
    }

    public int getNumberOfCurrentUsers() {
        return numberOfCurrentUsers;
    }

    public Date getLastUsedTime() {
        return lastUsedTime;
    }

    public int getSalonCapacity() {
        return salonCapacity;
    }
}
