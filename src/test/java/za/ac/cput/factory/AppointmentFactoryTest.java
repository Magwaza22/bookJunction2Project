package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.User;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentFactoryTest {

    @Test
    void testBuildAppointment() {
        User user = new User();
        Location location = new Location();
        Appointment a = AppointmentFactory.buildAppointment(user, "collection", LocalDateTime.of(2024, 9, 2, 14, 30), location);
        assertNotNull(a);
        System.out.println(a.toString());
    }

    @Test
    void testBuildAppointmentWithFail() {
        User user = new User();
        Location location = new Location();
        Appointment a = AppointmentFactory.buildAppointment(user, null, LocalDateTime.of(2024, 9, 2, 14, 30), location);
        assertNotNull(a);
        System.out.println(a.toString());
    }
}
