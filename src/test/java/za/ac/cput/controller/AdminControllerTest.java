package za.ac.cput.controller;

import za.ac.cput.domain.Admin;
import za.ac.cput.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AdminControllerTest {

    @Mock
    private AdminService adminService;

    @InjectMocks
    private AdminController adminController;

    private Admin admin;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        admin = new Admin.Builder()
                .setAdminID(1L)
                .setName("John Doe")
                .setEmail("john@example.com")
                .setPassword("securePassword")
                .setPhoneNumber("1234567890")
                .build();
    }

    @Test
    void testCreateAdmin() {
        when(adminService.create(any(Admin.class))).thenReturn(admin);

        ResponseEntity<Admin> response = adminController.createAdmin(admin);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(admin, response.getBody());
    }

    @Test
    void testGetAdmin() {
        when(adminService.read(1L)).thenReturn(admin);

        ResponseEntity<Admin> response = adminController.getAdmin(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(admin, response.getBody());
    }

    @Test
    void testGetAdmin_NotFound() {
        when(adminService.read(2L)).thenReturn(null);

        ResponseEntity<Admin> response = adminController.getAdmin(2L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testUpdateAdmin() {
        when(adminService.update(any(Admin.class))).thenReturn(admin);

        ResponseEntity<Admin> response = adminController.updateAdmin(admin);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(admin, response.getBody());
    }

    @Test
    void testGetAllAdmins() {
        List<Admin> adminList = new ArrayList<>();
        adminList.add(admin);
        when(adminService.getAll()).thenReturn(adminList);

        ResponseEntity<List<Admin>> response = adminController.getAllAdmins();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testDeleteAdmin() {
        doNothing().when(adminService).delete(1L);

        ResponseEntity<Void> response = adminController.deleteAdmin(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(adminService, times(1)).delete(1L);
    }
}