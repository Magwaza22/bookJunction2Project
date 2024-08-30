package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.User;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentFactoryTest {

    @Test
    void testCreateAppointmentWithValidData() {
        // Given valid data
        User user = new User.Builder()
                .setUserId("user123")
                .setName("Jane Doe")
                .setEmail("jane.doe@example.com")
                .setPhoneNumber("987-654-3210")
                .build();

        Location location = new Location.Builder()
                .setId(1L)
                .setAddress("456 Another St")
                .build();

        LocalDateTime dateTime = LocalDateTime.of(2024, 8, 17, 10, 15);

        // Create an appointment with valid data
        Appointment appointment = AppointmentFactory.createAppointment(
                123L, "Book pickup", dateTime, user.getUserId(), user.getName(), user.getEmail(), user.getPhoneNumber(), location.getId(), location.getAddress());

        // Assert that the appointment is created and not null
        assertNotNull(appointment, "Appointment should not be null with valid data.");
        assertEquals(123L, appointment.getAppointmentId());
        assertEquals(user, appointment.getUser());
        assertEquals("Book pickup", appointment.getDescription());
        assertEquals(dateTime, appointment.getDateTime());
        assertEquals(location, appointment.getLocation());
    }

    @Test
    void testCreateAppointmentWithNullAppointmentId() {
        // Given a null appointmentId
        User user = new User.Builder()
                .setUserId("user123")
                .setName("Jane Doe")
                .setEmail("jane.doe@example.com")
                .setPhoneNumber("987-654-3210")
                .build();
        Location location = new Location.Builder().setId(1L).setAddress("456 Another St").build();
        LocalDateTime dateTime = LocalDateTime.of(2024, 8, 17, 10, 15);

        // When creating an appointment with null appointmentId
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AppointmentFactory.createAppointment(null, "Book pickup", dateTime, user.getUserId(), user.getName(), user.getEmail(), user.getPhoneNumber(), location.getId(), location.getAddress())
        );

        // Then the exception message should be correct
        assertEquals("Invalid input: none of the parameters can be null or empty", exception.getMessage());
    }

    @Test
    void testCreateAppointmentWithNullUser() {
        // Given a null user
        Long appointmentId = 123L;
        Location location = new Location.Builder().setId(1L).setAddress("456 Another St").build();
        LocalDateTime dateTime = LocalDateTime.of(2024, 8, 17, 10, 15);

        // When creating an appointment with null user
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AppointmentFactory.createAppointment(appointmentId, "Book pickup", dateTime, null, "Jane Doe", "jane.doe@example.com", "987-654-3210", location.getId(), location.getAddress())
        );

        // Then the exception message should be correct
        assertEquals("Invalid input: none of the parameters can be null or empty", exception.getMessage());
    }

    @Test
    void testCreateAppointmentWithNullDescription() {
        // Given a null description
        User user = new User.Builder()
                .setUserId("user123")
                .setName("Jane Doe")
                .setEmail("jane.doe@example.com")
                .setPhoneNumber("987-654-3210")
                .build();
        Location location = new Location.Builder().setId(1L).setAddress("456 Another St").build();
        LocalDateTime dateTime = LocalDateTime.of(2024, 8, 17, 10, 15);

        // When creating an appointment with null description
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AppointmentFactory.createAppointment(123L, null, dateTime, user.getUserId(), user.getName(), user.getEmail(), user.getPhoneNumber(), location.getId(), location.getAddress())
        );

        // Then the exception message should be correct
        assertEquals("Invalid input: none of the parameters can be null or empty", exception.getMessage());
    }

    @Test
    void testCreateAppointmentWithNullDateTime() {
        // Given a null dateTime
        User user = new User.Builder()
                .setUserId("user123")
                .setName("Jane Doe")
                .setEmail("jane.doe@example.com")
                .setPhoneNumber("987-654-3210")
                .build();
        Location location = new Location.Builder().setId(1L).setAddress("456 Another St").build();

        // When creating an appointment with null dateTime
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AppointmentFactory.createAppointment(123L, "Book pickup", null, user.getUserId(), user.getName(), user.getEmail(), user.getPhoneNumber(), location.getId(), location.getAddress())
        );

        // Then the exception message should be correct
        assertEquals("Invalid input: none of the parameters can be null or empty", exception.getMessage());
    }

    @Test
    void testCreateAppointmentWithNullLocation() {
        // Given a null location
        User user = new User.Builder()
                .setUserId("user123")
                .setName("Jane Doe")
                .setEmail("jane.doe@example.com")
                .setPhoneNumber("987-654-3210")
                .build();
        Long appointmentId = 123L;
        String description = "Book pickup";
        LocalDateTime dateTime = LocalDateTime.of(2024, 8, 17, 10, 15);

        // When creating an appointment with null location
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AppointmentFactory.createAppointment(appointmentId, description, dateTime, user.getUserId(), user.getName(), user.getEmail(), user.getPhoneNumber(), null, null)
        );

        // Then the exception message should be correct
        assertEquals("Invalid input: none of the parameters can be null or empty", exception.getMessage());
    }
}
