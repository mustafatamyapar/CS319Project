package com.CovidShark;

import java.util.Date;

/**
 * The Salon class.
 */
public class Salon {

    /**
     * The salonType String holds the salon type.
     */
    private String salonType;

    /**
     * The lastUsedTime is a Date which is a built-in library of Java.
     */
    private Date lastUsedTime;

    /**
     * The numberOfCurrentUsers integer holds the number of current users of a salon.
     */
    private int numberOfCurrentUsers;

    /**
     * The salonCapacity integer holds the capacity of a salon.
     */
    private String salonCapacity;


    public Salon(String salonType, String salonCapacity) {
        this.salonType = salonType;
        lastUsedTime = null;
        numberOfCurrentUsers = 0;
        this.salonCapacity = salonCapacity;
    }

    public Salon(){

    }

    public void init(String salonType, String salonCapacity){
        this.salonType = salonType;
        lastUsedTime = null;
        numberOfCurrentUsers = 0;
        this.salonCapacity = salonCapacity;
    }

    /**
     * The getSalonType() operation gets the salon type.
     * @return the salon type.
     */
    public String getSalonType() {
        return salonType;
    }

    /**
     * The getSalonCapacity() operation gets the capacity of a salon.
     * @return the capacity of a salon.
     */
    public String getSalonCapacity() {return salonCapacity;}


    /**
     * The getLastUsedTime() operation gets the last used time of a salon.
     * @return the last used time of a salon.
     */
    public Date getLastUsedTime() {
        return lastUsedTime;
    }

    /**
     * The getNumberOfCurrentUsers() operation gets the number of current users in a salon.
     * @return the number of current users in a salon.
     */
    public int getNumberOfCurrentUsers() {
        return numberOfCurrentUsers;
    }

    /**
     * The usedBy(BaseUser user) operation gets the users who used a salon.
     */
    public void usedBy(BaseUser user){
        numberOfCurrentUsers++;
        lastUsedTime = java.util.Calendar.getInstance().getTime();
    }

    /**
     * The userLeftSalon(BaseUser user) operation shows when users leave the salon.
     */
    public void userLeftSalon(BaseUser user){
        numberOfCurrentUsers--;
        lastUsedTime = java.util.Calendar.getInstance().getTime();
    }
}
