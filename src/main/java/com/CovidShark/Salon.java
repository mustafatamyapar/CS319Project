package main.java.com.CovidShark;

public class Salon {

    private String salonType;
    private Date lastUsedTime;
    private int numberOfCurrentUsers;
    private int salonCapacity;

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
