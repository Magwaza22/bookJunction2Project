package za.ac.cput.service;
 import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.User;
import za.ac.cput.factory.AppointmentFactory;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.repository.AppointmentRepository;
import za.ac.cput.repository.LocationRepository;
import za.ac.cput.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    private static Appointment appointment;
    private static User user;
    private static Location location;

    @BeforeEach
    void setup() {
        try {
            appointmentRepository.deleteAll();
            locationRepository.deleteAll();
            userRepository.deleteAll();

            user = UserFactory.createUser(Integer.valueOf("user123"), "John Doe", "john@example.com", "1234567890");
            userRepository.save(user);

            location = new Location.Builder()
                    .setAddress("143 Sir Lowry Rd")
                    .build();
            location = locationRepository.save(location);

            LocalDateTime dateTime = LocalDateTime.of(2024, 8, 17, 10, 15);
            appointment = AppointmentFactory.buildAppointment( user, "drop off", dateTime, location); // ID is null
        } catch (Exception e) {
            fail("Setup failed: " + e.getMessage());
        }
    }

    @Test
    @Order(1)
    void create() {
        try {
            Appointment createdAppointment = appointmentService.create(appointment);
            assertNotNull(createdAppointment, "The created appointment should not be null.");
            assertEquals(appointment.getUser(), createdAppointment.getUser(), "User should match.");
            assertEquals(appointment.getDescription(), createdAppointment.getDescription(), "Description should match.");
            assertEquals(appointment.getDateTime(), createdAppointment.getDateTime(), "DateTime should match.");
            assertEquals(appointment.getLocation(), createdAppointment.getLocation(), "Location should match.");
        } catch (Exception e) {
            fail("Create test failed: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    void read() {
        try {
            Appointment createdAppointment = appointmentService.create(appointment);
            Appointment readAppointment = appointmentService.read(createdAppointment.getAppointmentId());
            assertNotNull(readAppointment, "The read appointment should not be null.");
            assertEquals(createdAppointment.getAppointmentId(), readAppointment.getAppointmentId(), "IDs should match.");
            assertEquals(createdAppointment.getUser(), readAppointment.getUser(), "User should match.");
            assertEquals(createdAppointment.getDescription(), readAppointment.getDescription(), "Description should match.");
            assertEquals(createdAppointment.getDateTime(), readAppointment.getDateTime(), "DateTime should match.");
            assertEquals(createdAppointment.getLocation(), readAppointment.getLocation(), "Location should match.");
        } catch (Exception e) {
            fail("Read test failed: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    void update() {
        try {
            Appointment createdAppointment = appointmentService.create(appointment);
            Appointment updatedAppointment = new Appointment.Builder()
                    .copy(createdAppointment)
                    .setDescription("Updated description")
                    .build();
            Appointment result = appointmentService.update(updatedAppointment);
            assertNotNull(result, "The updated appointment should not be null.");
            assertEquals(updatedAppointment.getAppointmentId(), result.getAppointmentId(), "IDs should match.");
            assertEquals(updatedAppointment.getDescription(), result.getDescription(), "Description should match.");
        } catch (Exception e) {
            fail("Update test failed: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    void getAll() {
        try {

            Appointment appointment1 = AppointmentFactory.buildAppointment( user, "First appointment", LocalDateTime.now(), location);
            Appointment appointment2 = AppointmentFactory.buildAppointment(user, "Second appointment", LocalDateTime.now(), location);
            appointmentService.create(appointment1);
            appointmentService.create(appointment2);

            // List<Appointment> appointments = appointmentService.getall();

            // assertNotNull(appointments, "The list of appointments should not be null.");
            // assertTrue(appointments.size() >= 2, "The list should contain at least 2 appointments.");
        } catch (Exception e) {
            fail("GetAll test failed: " + e.getMessage());
        }
    }


    @Test
    @Order(5)
    void delete() {

        try {
            Appointment createdAppointment = appointmentService.create(appointment);
            Integer id = createdAppointment.getAppointmentId();
            assertNotNull(appointmentService.read(id), "The appointment should exist before deletion.");

            appointmentService.delete(id);
            assertThrows(NoSuchElementException.class, () -> {
                Appointment deletedAppointment = appointmentService.read(id);
                if (deletedAppointment == null) {
                    throw new NoSuchElementException("Appointment not found.");
                }
            }, "The appointment should be deleted.");
        } catch (Exception e) {
            fail("Delete test failed: " + e.getMessage());
        }
    }
}
