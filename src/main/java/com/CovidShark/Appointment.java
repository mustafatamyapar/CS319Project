package com.CovidShark;

import java.util.Date;

/**
 * The Appointment class.
 */
public class Appointment {

    /**
     * The appointmentDate is a variable of Java's built-in Date library.
     */
    private Date appointmentDate;

    /**
     * The doctorName String contains the name of a doctor at the health center.
     */
    private String doctorName;

    /**
     * The appointmentCode String contains the unique code of an appointment requested by a user.
     */
    private String appointmentCode;

    public Appointment(Date appointmentDate, String doctorName, String appointmentCode) {
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
        this.appointmentCode = appointmentCode;
    }

    /**
     * The setAppointmentDate(Date appointmentDate) operation sets the appointment date which is requested by a user.
     */
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * The setDoctorName(String doctorName) operation sets the doctor which the user will get treatment from.
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * The setAppointmentCode(String appointmentCode) operation sets the unique appointment code of an appointment
     * which is requested by a user.
     */
    public void setAppointmentCode(String appointmentCode) {
        this.appointmentCode = appointmentCode;
    }

    /**
     * The getAppointmentDate() operation gets an appointment from the system.
     * @return the appointment date.
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * The getAppointmentCode() operation gets the code of an appointment requested by a user.
     * @return the appointment code.
     */
    public String getAppointmentCode() {
        return appointmentCode;
    }

    /**
     * The getDoctorName() operation gets the doctor name of a specific appointment.
     * @return the doctor name.
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * The getAppointmentByCode(String appointmentCode, BaseUser user) operation gets the appointment by its
     * unique code.
     * @return the appointment object.
     */
   /*
    public Appointment getAppointmentByCode(String appointmentCode, BaseUser user)
    {
        for(int i = 0; i < user.getAppointments())
        user.getAppointments().get(i)
    }
    */
}
