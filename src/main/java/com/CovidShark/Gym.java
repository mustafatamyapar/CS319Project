package com.CovidShark;

import java.util.List;
import java.util.Objects;

/**
 * The Gym class.
 */
public class Gym {

    /**
     * The salons list holds the salon objects.
     */
    private List<Salon> salons;

    public Gym(List<Salon> salons) {
        this.salons = salons;
    }

    public Gym(){

    }

    public void initializeCons(){
        this.salons = salons;
    }
    /**
     * The getSalonUsers(String salonType) operation gets the salon users.
     * @return the number of current users in a salon of a gym.
     */
    public int getSalonUsers(String salonType) {
       int cur = 0;
       for(int i = 0; i < salons.size(); i++) {
           if (Objects.equals(salons.get(i).getSalonType(), salonType))
              cur = salons.get(i).getNumberOfCurrentUsers();
       }
       return cur;
    }
}
