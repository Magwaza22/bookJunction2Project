package za.ac.cput.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment {
    @Id
    private String appointmentId;
    private String buyerId;
    private String description;
    private LocalDateTime dateTime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address")
    private Location location;
    protected Appointment() {
    }

    private Appointment(Builder builder) {
        this.appointmentId = builder.appointmentId;
        this.buyerId = builder.buyerId;
        this.description = builder.description;
        this.dateTime = builder.dateTime;
        this.location = builder.location;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(getAppointmentId(), that.getAppointmentId()) &&
                Objects.equals(getBuyerId(), that.getBuyerId()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getDateTime(), that.getDateTime()) &&
                Objects.equals(getLocation(), that.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAppointmentId(), getBuyerId(), getDescription(), getDateTime(), getLocation());
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", location=" + location +
                '}';
    }

    public static class Builder {
        private String appointmentId;
        private String buyerId;
        private String description;
        private LocalDateTime dateTime;
        private Location location;

        public Builder setAppointmentId(String appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }

        public Builder setBuyerId(String buyerId) {
            this.buyerId = buyerId;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public Builder copy(Appointment appointment) {
            this.appointmentId = appointment.appointmentId;
            this.buyerId = appointment.buyerId;
            this.description = appointment.description;
            this.dateTime = appointment.dateTime;
            this.location = appointment.location;
            return this;
        }

        public Appointment build() {
            return new Appointment(this);
        }
    }
}
