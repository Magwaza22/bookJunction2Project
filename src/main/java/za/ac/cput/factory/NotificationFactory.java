package za.ac.cput.factory;

//import org.apache.catalina.User;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Notification;

import za.ac.cput.util.Helper;
import java.time.LocalDate;
import za.ac.cput.domain.User;
public class NotificationFactory {



        public Notification createNotification(int notificationID, User userID, String message, LocalDate date) {

            if (Helper.isNullOrEmpty(String.valueOf(notificationID)) || Helper.isNullOrEmpty(String.valueOf(userID))
                    || Helper.isNullOrEmpty(String.valueOf(message))
                    || Helper.isNullOrEmpty(String.valueOf(date))) {
                return null;
            }
            return new Notification.Builder()
                    .setNotificationID(notificationID)
                    .setUserID(userID)
                    .setMessage(message)
                    .setDate(date)
                    .build();
        }




public static Notification buildNotification(int notificationID, User userID, String message, LocalDate date) {
    throw new UnsupportedOperationException();

}
}


