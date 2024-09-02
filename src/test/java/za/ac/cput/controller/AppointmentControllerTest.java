package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.User;
import za.ac.cput.factory.AppointmentFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppointmentControllerTest {

    /*@Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "/appointment";
    private static Appointment appointment;

    @BeforeAll
    public static void setUp() {
        // Assuming AppointmentFactory is correctly set up
        appointment = AppointmentFactory.createAppointment(
                        1L, // example ID
                new User(),
                "Meeting with client",
                LocalDateTime.of(2024, 8, 31, 14, 0), // mock or create a real Location object if needed
                new Location() // mock or create a real User object if needed
                );
    }

    @Test
    void save() {
        String url = BASE_URL + "/save";
        ResponseEntity<Appointment> postResponse = restTemplate.postForEntity(url, appointment, Appointment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Appointment appointmentSaved = postResponse.getBody();
        assertEquals(appointment.getAppointmentId(), appointmentSaved.getAppointmentId());
        System.out.println("Saved data: " + appointmentSaved);
    }

    @Test
    void read() {
        String url = BASE_URL + "/read/" + appointment.getAppointmentId();
        ResponseEntity<Appointment> response = restTemplate.getForEntity(url, Appointment.class);
        assertEquals(appointment.getAppointmentId(), response.getBody().getAppointmentId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void deleteByID() {
        String url = BASE_URL + "/deletebyid/" + appointment.getAppointmentId();
        restTemplate.delete(url);
        System.out.println("Deleted appointment");
    }

    @Test
    void getAll() {
        String url = BASE_URL + "/getall";
        ResponseEntity<Appointment[]> response = restTemplate.getForEntity(url, Appointment[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0, "Appointments list should not be empty");
        System.out.println("All appointments: ");
        for (Appointment app : response.getBody()) {
            System.out.println(app);
        }
    }*/
}
