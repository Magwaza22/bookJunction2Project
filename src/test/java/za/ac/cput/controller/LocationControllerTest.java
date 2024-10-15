package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Location;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LocationControllerTest {

    //TODO READ & DELETEBY failing......,
    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/location";
    private static Location location;

    @BeforeAll
    public static void init() {
        location = new Location.Builder()
                .setAddress("123 Test Street")
                .build();
    }

    @Test
    @Order(1)
    void save() {
        String url = BASE_URL + "/save";
        ResponseEntity<Location> postResponse = restTemplate.postForEntity(url, location, Location.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());

        Location savedLocation = postResponse.getBody();
        assertEquals(location.getAddress(), savedLocation.getAddress());

        System.out.println("Saved location: " + savedLocation);
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + location.getId();
        ResponseEntity<Location> response = restTemplate.getForEntity(url, Location.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        System.out.println("Read location: " + response.getBody());
    }

    @Test
    @Order(3)
    void deleteByID() {
        String url = BASE_URL + "/deletebyid/" + location.getId();
        restTemplate.delete(url);

        ResponseEntity<String> responseAfterDelete = restTemplate.getForEntity(BASE_URL + "/read/" + location.getId(), String.class);
        assertEquals(HttpStatus.NOT_FOUND, responseAfterDelete.getStatusCode());
        System.out.println("Deleted location with ID: " + location.getId());
    }

    @Test
    @Order(4)
    void getAll() {

        ResponseEntity<List> response = restTemplate.getForEntity(BASE_URL + "/getall", List.class);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        System.out.println("All locations: " + response.getBody());
    }
}