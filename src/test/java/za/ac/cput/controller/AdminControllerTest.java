package za.ac.cput.controller;

import org.springframework.http.HttpMethod;
import za.ac.cput.domain.Admin;
import za.ac.cput.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/admin"; // Adjust to your actual URL
    private Admin admin;

    @BeforeEach
    void setUp() {
        admin = new Admin.Builder()
                .setAdminID(1)
                .setName("John Doe")
                .setEmail("john@example.com")
                .setPassword("securePassword")
                .setPhoneNumber("1234567890")
                .build();
    }

    @Test
    void testCreateAdmin() {
        ResponseEntity<Admin> response = restTemplate.postForEntity(BASE_URL + "/create", admin, Admin.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(admin.getAdminID(), response.getBody().getAdminID());
    }

    @Test
    void testGetAdmin() {
        restTemplate.postForEntity(BASE_URL + "/create", admin, Admin.class); // Ensure the admin is created first

        ResponseEntity<Admin> response = restTemplate.getForEntity(BASE_URL + "/read/" + admin.getAdminID(), Admin.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(admin.getAdminID(), response.getBody().getAdminID());
    }

    @Test
    void testGetAdmin_NotFound() {
        ResponseEntity<Admin> response = restTemplate.getForEntity(BASE_URL + "/read/2", Admin.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testGetAllAdmins() {
        List<Admin> adminList = new ArrayList<>();
        adminList.add(admin);
        restTemplate.postForEntity(BASE_URL + "/create", admin, Admin.class); // Ensure the admin is created first

        ResponseEntity<List> response = restTemplate.getForEntity(BASE_URL + "/all", List.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testDeleteAdmin() {
        restTemplate.postForEntity(BASE_URL + "/create", admin, Admin.class); // Ensure the admin is created first

        ResponseEntity<Void> response = restTemplate.exchange(BASE_URL + "/delete/" + admin.getAdminID(), HttpMethod.DELETE, null, Void.class);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}