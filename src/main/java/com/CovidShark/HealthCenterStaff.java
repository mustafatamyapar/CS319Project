package main.java.com.CovidShark;

import java.util.List;

public class HealthCenterStaff extends BaseUser {
    private List<Appointment> appointmentRequests;

    public HealthStatus getDiagnosis(int idNumber) {
    }

    public void updateDiagnosis(int idNumber) {

    }

    public HealthStatus seeIndividualsCovidStatus(int idNumber) {

    }

    public List<Student> getDormCovidInfo(int idNumber) {

    }

    public void updatePCRTest(int idNumber, int result) {

    }

    public void giveAppointment(String appointmentCode) {
        appointmentRequests.add(appointmentCode);
    }

    public void cancelAppointmentRequest(String appointmentCode) {
        appointmentRequests.remove(appointmentCode);
    }
}
