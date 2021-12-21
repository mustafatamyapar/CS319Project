package com.CovidShark;

import java.util.ArrayList;
import java.util.List;

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

    public BaseUser(String idNumber, String name, String email, String phoneNumber) {

        this.idNumber = idNumber;
        this.name = name;
        this.email = email;
        healthStatus = null;
        this.notifications = new ArrayList<Notification>();
        this.phoneNumber = phoneNumber;
        this.appointments = new ArrayList<Appointment>();
        appointment = null;
        this.password = null;
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
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void deleteNotification(int notificationCode) {
        for (int i = 0; i < notifications.size(); i++) {
            if (notifications.get(i).getNotificationCode() == notificationCode) {
                notifications.remove(i);
            }
        }
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
