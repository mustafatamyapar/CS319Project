package com.CovidShark;

import java.util.List;

/**
 * The HealthCenterStaff class extends the BaseUser class.
 */
public class HealthCenterStaff extends BaseUser {
    /**
     * The appointmentRequests list holds appointment objects.
     */
    private List<Appointment> appointmentRequests;

    public HealthCenterStaff(String idNumber, String name, String email, String phoneNumber, List<Appointment> appointmentRequests) {
        super(idNumber, name, email, phoneNumber);
        this.appointmentRequests = appointmentRequests;
    }

    public HealthCenterStaff(){

    }

    /**
     * The getUserById(int ID) operation gets the user by their id number.
     * @return the user.
     */
    //public BaseUser getUserById(int ID) {
    //}

    /**
     * The getDiagnosis(int idNumber) operation gets the diagnosis of a user with their id number.
     * @return the health status of the user.
     */
    //public HealthStatus getDiagnosis(int idNumber) {
    //}

    /**
     * The updateDiagnosis(int idNumber) operation updates the diagnosis of a user with their id number.
     */
    //public void updateDiagnosis(int idNumber) {
    //}

    /**
     * The seeIndividualsCovidStatus(int idNumber) operation sees the individuals covid status with their id number.
     * @return the health status of the user.
     */
    //public HealthStatus seeIndividualsCovidStatus(int idNumber) {
    //}

    /**
     * The getDormCovidInfo(int idNumber) operation gets the covid information of a dorm.
     * @return list of students who are covid infected.
     */
   // public List<Student> getDormCovidInfo(int idNumber) {
    //}

    /**
     * The updatePCRTest(int idNumber, int result) operation updates the PCR test of a user with their id number.
     */
   // public void updatePCRTest(int idNumber, int result) {
   // }

    /**
     * The giveAppointment(String appointmentCode) operation gives appointment to a user if an appointment has been requested.
     */
   // public void giveAppointment(String appointmentCode) {
   //     appointmentRequests.add(appointmentCode);
   // }

    /**
     * The cancelAppointmentRequest(String appointmentCode) operation cancels an appointment.
     */
    public void cancelAppointmentRequest(String appointmentCode) {
        appointmentRequests.remove(appointmentCode);
    }
}
