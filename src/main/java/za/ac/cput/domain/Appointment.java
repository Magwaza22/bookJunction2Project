package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long appointmentId;  // Changed from String to Long

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String description;

    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    protected Appointment() {
    }

    private Appointment(Builder builder) {
        this.appointmentId = builder.appointmentId;
        this.user = builder.user;
        this.description = builder.description;
        this.dateTime = builder.dateTime;
        this.location = builder.location;
    }

    public Long getAppointmentId() {  // Changed return type from String to Long
        return appointmentId;
    }

    public User getUser() {
        return user;
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
        return Objects.equals(appointmentId, that.appointmentId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(description, that.description) &&
                Objects.equals(dateTime, that.dateTime) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, user, description, dateTime, location);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", location=" + location +
                '}';
    }

    public static class Builder {
        private Long appointmentId;  // Changed from String to Long
        private User user;
        private String description;
        private LocalDateTime dateTime;
        private Location location;

        public Builder setAppointmentId(Long appointmentId) {  // Changed parameter type from String to Long
            this.appointmentId = appointmentId;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
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
            this.user = appointment.user;
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
