
package za.ac.cput.service;

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

class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminService adminService;

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
    void testCreate() {
        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

        Admin createdAdmin = adminService.create(admin);
        assertNotNull(createdAdmin);
        assertEquals(admin.getAdminID(), createdAdmin.getAdminID());
    }

    @Test
    void testRead() {
        when(adminRepository.findById(String.valueOf(1L))).thenReturn(Optional.of(admin));

        Admin foundAdmin = adminService.read(1L);
        assertNotNull(foundAdmin);
        assertEquals(admin.getAdminID(), foundAdmin.getAdminID());
    }

    @Test
    void testRead_AdminNotFound() {
        when(adminRepository.findById(String.valueOf(2L))).thenReturn(Optional.empty());

        Admin foundAdmin = adminService.read(2L);
        assertNull(foundAdmin);
    }

    @Test
    void testUpdate() {
        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

        Admin updatedAdmin = adminService.update(admin);
        assertNotNull(updatedAdmin);
        assertEquals(admin.getAdminID(), updatedAdmin.getAdminID());
    }

    @Test
    void testGetAll() {
        List<Admin> adminList = new ArrayList<>();
        adminList.add(admin);
        when(adminRepository.findAll()).thenReturn(adminList);

        List<Admin> allAdmins = adminService.getAll();
        assertNotNull(allAdmins);
        assertEquals(1, allAdmins.size());
    }

    @Test
    void testDelete() {
        doNothing().when(adminRepository).deleteById(String.valueOf(1L));

        assertDoesNotThrow(() -> adminService.delete(1L));
        verify(adminRepository, times(1)).deleteById(String.valueOf(1L));
    }
}