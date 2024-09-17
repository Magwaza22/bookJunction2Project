package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.User;
import za.ac.cput.factory.AppointmentFactory;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppointmentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/appointment";
    private static Appointment appointment;

    @BeforeAll
    public static void init() {
        User user = new User();
        Location location = new Location();
        appointment = new Appointment.Builder()
                .setUser(user)
                .setDescription("Test appointment")
                .setDateTime(LocalDateTime.now())
                .setLocation(location)
                .build();
    }

    @Test
    @Order(1)
    void save() {
        String url = BASE_URL + "/save";
        ResponseEntity<Appointment> postResponse = restTemplate.postForEntity(url, appointment, Appointment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());

        Appointment savedAppointment = postResponse.getBody();
        assertEquals(appointment.getDescription(), savedAppointment.getDescription());

        System.out.println("Saved appointment: " + savedAppointment);
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + appointment.getAppointmentId();
        ResponseEntity<Appointment> response = restTemplate.getForEntity(url, Appointment.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        System.out.println("Read appointment: " + response.getBody());
    }

    @Test
    @Order(3)
    void deleteByID() {
        String url = BASE_URL + "/deletebyid/" + appointment.getAppointmentId();
        restTemplate.delete(url);

        ResponseEntity<String> responseAfterDelete = restTemplate.getForEntity(BASE_URL + "/read/" + appointment.getAppointmentId(), String.class);
        assertEquals(HttpStatus.NOT_FOUND, responseAfterDelete.getStatusCode());
        System.out.println("Deleted appointment with ID: " + appointment.getAppointmentId());
    }

    @Test
    @Order(4)
    void getAll() {
        ResponseEntity<List> response = restTemplate.getForEntity(BASE_URL + "/getall", List.class);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        System.out.println("All appointments: " + response.getBody());
    }
}