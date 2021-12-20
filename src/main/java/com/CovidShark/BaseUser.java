package main.java.com.CovidShark;

import main.java.com.CovidShark.Notification;
import main.java.com.CovidShark.HealthStatus;
import java.util.List;
import java.util.ListResourceBundle;

public class BaseUser {
    private String idNumber;
    private String name;
    private String email;
    private String password;
    private HealthStatus healthStatus;
    private List<Notification> notifications;
    private String phoneNumber;
    private List<Appointment> appointments;
    private Appointment appointment;

    public BaseUser(String idNumber, String name, String email, HealthStatus healthStatus,
                    List<Notification> notifications, String phoneNumber, List<Appointment> appointments,
                    Appointment appointment) {
        this.idNumber = idNumber;
        this.name = name;
        this.email = email;
        this.healthStatus = healthStatus;
        this.notifications = notifications;
        this.phoneNumber = phoneNumber;
        this.appointments = appointments;
        this.appointment = appointment;
    }

    public BaseUser() {
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public HealthStatus getHealthStatus(String idNumber) {
        return healthStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Notification> seeNotifications() {
        return notifications;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public Appointment getAppointment(String appointmentCode) {
        return appointment;
    }

    public Appointment createAppointment() {
        Appointment appointment = new Appointment();
        appointments.add(appointment);
        return appointment;
    }

    public void cancelAppointment(String appointmentCode) {
        appointments.remove(appointment);
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }
}
