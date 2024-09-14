package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Admin;
import za.ac.cput.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest
class AdminServiceTest {

    @Autowired
    private AdminService adminService;

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
    void testCreate() {
        Admin createdAdmin = adminService.create(admin);
        assertNotNull(createdAdmin);
        assertEquals(admin.getAdminID(), createdAdmin.getAdminID());
    }

}