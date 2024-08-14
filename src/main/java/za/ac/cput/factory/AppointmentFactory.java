package za.ac.cput.factory;

import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Location;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class AppointmentFactory {
    public static Appointment createAppointment(String appointmentId, String buyerId, String description, LocalDateTime dateTime) {
        Location location = null;

        if (Helper.isNullOrEmpty(String.valueOf(appointmentId)) || Helper.isNullOrEmpty(String.valueOf(buyerId)) ||
                Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(String.valueOf(dateTime)) || Helper.isNullOrEmpty(String.valueOf(location)))
            return null;


        return new Appointment.Builder()
                .setAppointmentId(appointmentId)
                .setBuyerId(buyerId)
                .setDescription(description)
                .setDateTime(dateTime)
                .setLocation(location)
                .build();
    }
}


