package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
@Entity
public class Appointment{
    @Id
    private String appointmentId;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    private String description;

    private LocalDateTime dateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "address")
    private Location location;
    protected Appointment() {
    }

    private Appointment(Builder builder) {
        this.appointmentId = builder.appointmentId;
        this.buyer = builder.buyer;
        this.description = builder.description;
        this.dateTime = builder.dateTime;
        this.location = builder.location;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public User getBuyerId() {
        return buyer;
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
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(appointmentId, that.appointmentId) && Objects.equals(buyer, that.buyer) && Objects.equals(description, that.description) && Objects.equals(dateTime, that.dateTime) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, buyer, description, dateTime, location);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", buyer_Id='" + buyer + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", location=" + location +
                '}';
    }

    public static class Builder {
        private String appointmentId;
        private User buyer;
        private String description;
        private LocalDateTime dateTime;
        private Location location;

        public Builder setAppointmentId(String appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }

        public Builder setBuyerId(User buyerId) {
            this.buyer = buyerId;
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
            this.buyer = appointment.buyer;
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
