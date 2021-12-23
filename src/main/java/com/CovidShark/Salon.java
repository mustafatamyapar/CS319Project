package com.CovidShark;

import java.util.Date;

public class Salon {

    private String salonType;
    private Date lastUsedTime;
    private int numberOfCurrentUsers;
    private int salonCapacity;

    public Salon(String salonType, int salonCapacity) {
        this.salonType = salonType;
        lastUsedTime = null;
        numberOfCurrentUsers = 0;
        this.salonCapacity = salonCapacity;
    }

    public String getSalonType() {
        return salonType;
    }
    public int getSalonCapacity() {return salonCapacity;}

    public Date getLastUsedTime() {
        return lastUsedTime;
    }
    public int getNumberOfCurrentUsers() {
        return numberOfCurrentUsers;
    }

    public void usedBy(BaseUser user){
        numberOfCurrentUsers++;
        lastUsedTime = java.util.Calendar.getInstance().getTime();
    }

    public void userLeftSalon(BaseUser user){
        numberOfCurrentUsers--;
        lastUsedTime = java.util.Calendar.getInstance().getTime();
    }
}
