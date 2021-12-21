package com.CovidShark;

import java.util.Date;

public class Appointment {

    private Date appointmentDate;
    private String doctorName;
    private String appointmentCode;

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
