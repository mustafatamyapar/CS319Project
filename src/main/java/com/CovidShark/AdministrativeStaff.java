package com.CovidShark;

import java.util.ArrayList;
import java.util.List;

public class AdministrativeStaff extends BaseUser {

    public AdministrativeStaff(String idNumber, String name, String email, String phoneNumber) {
        super(idNumber, name, email, phoneNumber);
    }

    public List<Student> getDormCovidInfo(int dormNumber) {
        // 1) find dorm
        /*
        // 2) get residents of dorm and check their covid status
        Dormitory dorm = ffgggg;
        List<Student> covidPositiveStudents = new ArrayList<Student>();
        List<Student> dormStudents = dorm.getStudents();
        for (int i = 0 ; i < dormStudents.size(); i++){
            if (dormStudents.get(i).getHealthStatus().isCovid())
                covidPositiveStudents.add(dormStudents.get(i));
        }
        return covidPositiveStudents;

         */
        return null;
    }

   public HealthStatus seeIndividualsCovidStatus(int idNumber) {
        // Will return covid status of a particular user
       // 1) reach out to user list loop through it and return user
       return null;
   }
}
