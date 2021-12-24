package com.CovidShark;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BaseUser {
    private String idNumber;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private HealthStatus healthStatus;
    private List<Notification> notifications;
    private List<Appointment> appointments;

    public BaseUser(String idNumber, String name, String email, String phoneNumber) {

        this.idNumber = idNumber;
        this.name = name;
        this.email = email;
        this.password = null;
        this.phoneNumber = phoneNumber;
        healthStatus = null;
        this.notifications = new ArrayList<Notification>();
        this.appointments = new ArrayList<Appointment>();

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

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // HS Operations
    public void setHealthStatus(String HESCode){
        healthStatus = new HealthStatus(HESCode);
    }


    public void requestPCRIfNeeded(){
        if(getHealthStatus().getVaccinationInfo().size() == 0)
        {
            Date Date1 = getHealthStatus().getPCRHistory().get(getHealthStatus().getPCRHistory().size() - 1).getPCRDate();
            Date Date2 = getHealthStatus().getPCRHistory().get(getHealthStatus().getPCRHistory().size() - 1).getPCRDate();

            long noOfDaysBetween = ChronoUnit.DAYS.between((Temporal) Date1, (Temporal) Date2);

            if(noOfDaysBetween >= 3)
            {
                Notification newNot= new Notification("You should give PCR test to the Health Center","Warning", "CovidShark");
                addNotification(newNot);
                getHealthStatus().setCampusPermission(false);
            }
        }
    }


    // notification operations
    public List<Notification> seeNotifications() {
        return notifications;
    }
    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public boolean deleteNotification(int notificationCode) {
        for (int i = 0; i < notifications.size(); i++) {
            if (notifications.get(i).getNotificationCode() == notificationCode) {
                notifications.remove(i);
                return true;
            }
        }
        return false;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }


    // healthStatus operations
    public void setHealthStatus(HealthStatus healthStatus) {

        this.healthStatus = healthStatus;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }


    // appointment operations
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public Appointment getAppointment(String appointmentCode) {
        for (int i = 0; i < appointments.size(); i++) {
            if (Objects.equals(appointments.get(i).getAppointmentCode(), appointmentCode)) {
                return appointments.get(i);
            }
        }
        return null;
    }

    public Appointment createAppointment(Date appointmentDate, String doctorName, String appointmentCode) {
        Appointment appointment = new Appointment(appointmentDate, doctorName, appointmentCode);
        appointments.add(appointment);
        return appointment;
    }


    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }


    public void setAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public boolean cancelAppointment(String appointmentCode) {
        //appointments.remove(appointment);
        for (int i = 0; i < appointments.size(); i++) {
            if (Objects.equals(appointments.get(i).getAppointmentCode(), appointmentCode)) {
                appointments.remove(i);
                return true;
            }
        }
        return false;
    }
}
