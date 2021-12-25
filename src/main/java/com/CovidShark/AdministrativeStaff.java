package com.CovidShark;

import java.util.ArrayList;
import java.util.List;

/**
 * AdministrativeStaff class extends BaseUser class.
 */
public class AdministrativeStaff extends BaseUser {

    public AdministrativeStaff(String idNumber, String name, String email, String phoneNumber) {
        super(idNumber, name, email, phoneNumber);
    }

    /**
     * The getDormCovidInfo(int dormNumber) operation finds the dorm by the dorm number (for instance dorm 81) and get the residents
     * of that dorm and checks their covid status.
     * This operation assumes that the specified dorm exists.
     * @pre List<Student> covidPositiveStudents != 0
     * @pre List<Student> dormStudents != 0
     * @return a list of students who are covid positive.
     */
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

    /**
     * The seeIndividualsCovidStatus(int idNumber) operation sees an individual's covid status.
     * For example, when a student becomes covid positive, an administrative staff can see that student's covid status
     * by this operation.
     */
   public HealthStatus seeIndividualsCovidStatus(int idNumber) {
        // Will return covid status of a particular user
       // 1) reach out to user list loop through it and return user
       return null;
   }
}
