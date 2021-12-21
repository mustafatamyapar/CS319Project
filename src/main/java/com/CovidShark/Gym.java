package com.CovidShark;

import java.util.List;

public class Gym {

    private List<Salon> salons;

   public int getSalonUsers(String salonType) {
       int cur = 0;
       for(int i = 0; i < salons.size(); i++) {
           if (salons.get(i).getSalonType() == salonType)
              cur = salons.get(i).getNumberOfCurrentUsers();
       }
       return cur;
    }
}
