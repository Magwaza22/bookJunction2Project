package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class Notification {
    @Id
    private int notificationID;
    private int userID;
    private String message;
    private Date date;


    public Notification() {
    }
    private Notification(Builder builder){
        this.notificationID = builder.notificationID;
        this.userID = builder.userID;
        this.message =builder.message;
        this.date= builder.date;

    }

    public Notification(Date date) {
        this.date = date;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public int getUserID() {
        return userID;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification that)) return false;
        return getNotificationID() == that.getNotificationID() && getUserID() == that.getUserID() && Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNotificationID(), getUserID(), getMessage(), getDate());
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
        private int userID;
        private String message;
        private Date date;

        public Builder setNotificationID(int notificationID) {
            this.notificationID = notificationID;
            return this;
        }

        public Builder setUserID(int userID) {
            this.userID = userID;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setDate(Date date) {
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
