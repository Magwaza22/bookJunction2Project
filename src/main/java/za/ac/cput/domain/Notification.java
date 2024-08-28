package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Notification {
    @Id
    private int notificationID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userID; // Buyer

    private String message;
    private LocalDate date;


    public Notification() {
    }
    private Notification(Builder builder){
        this.notificationID = builder.notificationID;
        this.userID = builder.userID;
        this.message =builder.message;
        this.date= builder.date;

    }

    public int getNotificationID() {
        return notificationID;
    }

    public User getUserID() {
        return userID;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return notificationID == that.notificationID && Objects.equals(userID, that.userID) && Objects.equals(message, that.message) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationID, userID, message, date);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationID=" + notificationID +
                ", userID=" + userID +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }

    public static class Builder{
        private int notificationID;
        private User userID;
        private String message;
        private LocalDate date;

        public Builder setNotificationID(int notificationID) {
            this.notificationID = notificationID;
            return this;
        }

        public Builder setUserID(User userID) {
            this.userID = userID;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }
        public Builder copy(Notification n) {
            this.notificationID = n.notificationID;
            this.userID = n.userID;
            this.message =n.message;
            this.date= n.date;
            return this;
        }
        public Notification build(){return new Notification(this);}
    }
}
