package com.CovidShark;

import java.util.ArrayList;
import java.util.List;

public class AdministrativeStaff extends BaseUser {

    public AdministrativeStaff(String idNumber, String name, String email, String phoneNumber) {
        super(idNumber, name, email, phoneNumber);
    }

    public List<Student> getDormCovidInfo(int dormNumber) {
        //will check each floor of the dorm in a for loop
        return null;
    }

   public HealthStatus seeIndividualsCovidStatus(int idNumber) {
        // will return covid status of a particular user
       return null;
   }
}
