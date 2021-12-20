package com.CovidShark;

public class Notification {

    private String message;
    private String notificationType;
    private String sender;
    private int notificationCode;

    public Notification(String message, String notificationType, String sender, int notificationCode) {
        this.message = message;
        this.notificationType = notificationType;
        this.sender = sender;
        this.notificationCode = notificationCode;
    }

    public Notification() {

    }

    public String getMessage() {
        return message;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public String getSender() {
        return sender;
    }

    public int getNotificationCode() {
        return notificationCode;
    }
}
