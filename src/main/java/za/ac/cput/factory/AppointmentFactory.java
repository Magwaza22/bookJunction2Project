package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;
import java.time.LocalDateTime;

import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class AppointmentFactory {

    public static Appointment buildAppointment(User user, String description, LocalDateTime dateTime, Location location) {

        if (user == null || Helper.isNullOrEmpty(description) || dateTime == null || location == null) {
            return null;
        }

        return new Appointment.Builder()
                .setUser(user)
                .setDescription(description)
                .setDateTime(dateTime)
                .setLocation(location)
                .build();
    }
}