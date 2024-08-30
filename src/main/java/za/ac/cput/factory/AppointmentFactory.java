package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;
import java.time.LocalDateTime;

public class AppointmentFactory {

    public static Appointment createAppointment(Long appointmentId, String description, LocalDateTime dateTime, String userId, String name, String email, String phoneNumber, Long locationId, String address) {
        if (Helper.isNullOrEmpty(description) || dateTime == null
                || Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(name)
                || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber)
                || locationId == null || Helper.isNullOrEmpty(address)) {
            throw new IllegalArgumentException("Invalid input: none of the parameters can be null or empty");
        }

        User user = UserFactory.createUser(userId, name, email, phoneNumber);
        if (user == null) {
            throw new IllegalArgumentException("Failed to create user");
        }

        Location location = new Location.Builder()
                .setId(locationId)
                .setAddress(address)
                .build();

        return new Appointment.Builder()
                .setAppointmentId(appointmentId)  // This can be null for auto-generation
                .setUser(user)
                .setDescription(description)
                .setDateTime(dateTime)
                .setLocation(location)
                .build();
    }

    public static Appointment createAppointment(Long appointmentId, User user, String description, LocalDateTime dateTime, Location location) {
        if (user == null || Helper.isNullOrEmpty(description) || dateTime == null || location == null) {
            throw new IllegalArgumentException("Invalid input: none of the parameters can be null or empty");
        }

        return new Appointment.Builder()
                .setAppointmentId(appointmentId)  // This can be null for auto-generation
                .setUser(user)
                .setDescription(description)
                .setDateTime(dateTime)
                .setLocation(location)
                .build();
    }

    // Method for creating an appointment without an ID (auto-generated ID)
    public static Appointment createAppointment(User user, String description, LocalDateTime dateTime, Location location) {
        if (user == null || Helper.isNullOrEmpty(description) || dateTime == null || location == null) {
            throw new IllegalArgumentException("Invalid input: none of the parameters can be null or empty");
        }

        return new Appointment.Builder()
                .setUser(user)
                .setDescription(description)
                .setDateTime(dateTime)
                .setLocation(location)
                .build();
    }
}
