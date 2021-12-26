package com.CovidShark;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * The BaseUser class.
 * This is the class that all user classes extend from.
 */
public class BaseUser {

    /**
     * The idNumber String holds the idNumber of a specific user.
     */
    private String idNumber;

    /**
     * The name String holds the name of a specific user.
     */
    private String name;

    /**
     * The email String holds the email of a specific user.
     */
    private String email;

    /**
     * The password String holds the password of a specific user.
     */
    private String password;

    /**
     * The phoneNumber String holds the phone number of a specific user.
     */
    private String phoneNumber;

    /**
     * The healthStatus object holds the health status of a specific user.
     */
    private HealthStatus healthStatus;

    /**
     * The notifications list holds the notification object.
     */
    private List<Notification> notifications;

    /**
     * The appointments list holds the Appointment object.
     */
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

    public BaseUser(){

    }

    public void initiateConstructor(String idNumber, String name, String email, String phoneNumber){
        this.idNumber = idNumber;
        this.name = name;
        this.email = email;
        this.password = null;
        this.phoneNumber = phoneNumber;
        healthStatus = null;
        this.notifications = new ArrayList<Notification>();
        this.appointments = new ArrayList<Appointment>();
    }
    /**
     * The getIdNumber() operation gets the id number of a specific user.
     * @return the id number of a user.
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * The setIdNumber(String idNumber) operation sets the id number of a specific user.
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * The getName() operation gets the name of a specific user.
     * @return the name of a user.
     */
    public String getName() {
        return name;
    }

    /**
     * The setName(String name) operation sets the name of a specific user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The getEmail() operation gets the email of a specific user.
     * @return the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * The setEmail(String email) operation sets the email of a specific user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * The getPassword() operation gets the password of a specific user.
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * The setPassword(String password) sets the password a specific user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * The getPhoneNumber() operation gets the phone number of a specific user.
     * @return the phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * The setPhoneNumber(String phoneNumber) operation sets the phone number of a specific user.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // HS Operations
    /**
     * The setHealthStatus(String HESCode) operation sets the health status of a specific user.
     */
    public void setHealthStatus(String HESCode){
        healthStatus = new HealthStatus(HESCode);
    }

    /**
     * The requestPCRIfNeeded() operation first checks if the size of the vaccinations of a user is 0, meaning that
     * the user is not vaccinated. In this condition, this operation checks the difference between two dates in order to
     * check the form submission of the non-vaccinated user because those users must get a PCR test in every 3 days.
     * This operation sends a message to the user if the user needs to get a PCR test immediately.
     */
    public void requestPCRIfNeeded() {
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
    /**
     * The seeNotifications() operation sees the notification of a specific user.
     * @return the list of notifications.
     */
    public List<Notification> seeNotifications() {
        return notifications;
    }

    /**
     * The addNotification(Notification notification) operation adds a notification to the notifications list to hold
     * the notifications of a user.
     */
    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    /**
     * The deleteNotification(int notificationCode) operation deletes a notification from the notifications list.
     * @return true if notification is deleted, false otherwise.
     */
    public boolean deleteNotification(int notificationCode) {
        for (int i = 0; i < notifications.size(); i++) {
            if (notifications.get(i).getNotificationCode() == notificationCode) {
                notifications.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * The setNotifications(List<Notification> notifications) operation sets the notifications.
     */
    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }


    /**
     * The getHealthStatus() operation gets the health status of a user.
     * @return the health status.
     */
    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    // appointment operations
    /**
     * The getAppointments() operation gets the appointments requested by a user.
     * @return appointments.
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * The getAppointment(String appointmentCode) operation gets a specific appointment requested by a user with the
     * unique appointment code.
     * @return the appointment from the list if the operation is successful, null otherwise.
     */
    public Appointment getAppointment(String appointmentCode) {
        for (int i = 0; i < appointments.size(); i++) {
            if (Objects.equals(appointments.get(i).getAppointmentCode(), appointmentCode)) {
                return appointments.get(i);
            }
        }
        return null;
    }

    /**
     * The createAppointment(Date appointmentDate, String doctorName, String appointmentCode) operation creates an
     * appointment and adds this appointment to the list of appointments.
     * @return an appointment.
     */
    public Appointment createAppointment(Date appointmentDate, String doctorName, String appointmentCode) {
        Appointment appointment = new Appointment(appointmentDate, doctorName, appointmentCode);
        appointments.add(appointment);
        return appointment;
    }

    /**
     * The setAppointments(List<Appointment> appointments) operation sets all the appointments.
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * The setAppointment(Appointment appointment) operation adds an appointment to the appointments list.
     */
    public void setAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    /**
     * The cancelAppointment(String appointmentCode) operation cancels a requested appointment using the appointment code.
     * @return true if the canceling operation is successful, false otherwise.
     */
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
