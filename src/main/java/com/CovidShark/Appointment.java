package com.CovidShark;

import java.util.Date;

public class Appointment {

    private Date appointmentDate;
    private String doctorName;
    private String appointmentCode;

    public Appointment(Date appointmentDate, String doctorName, String appointmentCode) {
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
        this.appointmentCode = appointmentCode;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setAppointmentCode(String appointmentCode) {
        this.appointmentCode = appointmentCode;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentCode() {
        return appointmentCode;
    }

    public String getDoctorName() {
        return doctorName;
    }

   /*
    public Appointment getAppointmentByCode(String appointmentCode, BaseUser user)
    {
        for(int i = 0; i < user.getAppointments())
        user.getAppointments().get(i)
    }
    */
}
