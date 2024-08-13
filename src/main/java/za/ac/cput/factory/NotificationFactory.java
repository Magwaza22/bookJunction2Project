package za.ac.cput.factory;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;

import java.util.Date;

public class NotificationFactory {

    public static Notification createNotification(int notificationID, int userID, String message, Date date) {
        if (Helper.isNullOrEmpty(String.valueOf(notificationID)) || Helper.isNullOrEmpty(String.valueOf(userID))
                || Helper.isNullOrEmpty(String.valueOf(message)) || Helper.isNullOrEmpty(String.valueOf(date)))
            return null;

        return new Notification.Builder().setNotificationID( notificationID)
                .setUserID(userID)
                .setMessage(message)
                .setDate(date)
                .build();
    }
}
