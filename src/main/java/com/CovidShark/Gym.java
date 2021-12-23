package com.CovidShark;

import java.util.List;
import java.util.Objects;

public class Gym {

    private List<Salon> salons;

    public Gym(List<Salon> salons) {
        this.salons = salons;
    }

    public int getSalonUsers(String salonType) {
       int cur = 0;
       for(int i = 0; i < salons.size(); i++) {
           if (Objects.equals(salons.get(i).getSalonType(), salonType))
              cur = salons.get(i).getNumberOfCurrentUsers();
       }
       return cur;
    }
}
