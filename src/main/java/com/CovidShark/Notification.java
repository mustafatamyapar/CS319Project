package com.CovidShark;

public class Notification {
    private static int code = 0;

    private String message;
    private String notificationType;
    private String sender;
    private int notificationCode;

    public Notification(String message, String notificationType, String sender) {
        this.message = message;
        this.notificationType = notificationType;
        this.sender = sender;
        this.notificationCode = code++;
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
