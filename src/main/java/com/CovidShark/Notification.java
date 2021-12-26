package com.CovidShark;

/**
 * The Notification class.
 */
public class Notification {
    /**
     * The code static integer holds the code number.
     */
    private static int code = 0;

    /**
     * The message String holds the message.
     */
    private String message;

    /**
     * The notificationType String holds the notification type.
     */
    private String notificationType;

    /**
     * The sender String holds the sender.
     */
    private String sender;

    /**
     * The notificationCode integer holds the code of a notification.
     */
    private int notificationCode;

    public Notification(String message, String notificationType, String sender) {
        this.message = message;
        this.notificationType = notificationType;
        this.sender = sender;
        this.notificationCode = code++;
    }

    /**
     * The getMessage() operation gets a message.
     * @return the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * The getNotificationType() operation gets the notification type.
     * @return the notification type.
     */
    public String getNotificationType() {
        return notificationType;
    }

    /**
     * The getSender() operation gets the sender.
     * @return the sender.
     */
    public String getSender() {
        return sender;
    }

    /**
     * The getNotificationCode() operation gets the notification code.
     * @return the notification code.
     */
    public int getNotificationCode() {
        return notificationCode;
    }
}
