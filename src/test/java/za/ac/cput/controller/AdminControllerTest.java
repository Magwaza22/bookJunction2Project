package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.domain.Admin;
import za.ac.cput.repository.AdminRepository;
import za.ac.cput.service.AdminService;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerTest {
/*
    //TODO GETAdmin, CreateAdmin, & GetAllAdmin failing........
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    private Admin admin;

    @BeforeEach
    void setUp() {
        adminRepository.deleteAll(); // Clear the database before each test
        admin = new Admin.Builder()
                .setAdminID(1)
                .setName("John Doe")
                .setEmail("john@example.com")
                .setPassword("securePassword")
                .setPhoneNumber("1234567890")
                .build();
        adminService.create(admin); // Save the admin to the database
    }

    @Test
    void testCreateAdmin() throws Exception {
        Admin newAdmin = new Admin.Builder()
                .setAdminID(2)
                .setName("Jane Smith")
                .setEmail("jane@example.com")
                .setPassword("anotherPassword")
                .setPhoneNumber("0987654321")
                .build();

        mockMvc.perform(post("/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(newAdmin)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.adminID").value(newAdmin.getAdminID()))
                .andExpect(jsonPath("$.name").value(newAdmin.getName()));
    }

    @Test
    void testGetAdmin() throws Exception {
        mockMvc.perform(get("/admin/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.adminID").value(admin.getAdminID()))
                .andExpect(jsonPath("$.name").value(admin.getName()));
    }

    @Test
    void testGetAdmin_NotFound() throws Exception {
        mockMvc.perform(get("/admin/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdateAdmin() throws Exception {
        admin.setName("John Updated"); // Update the name for testing

        mockMvc.perform(put("/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(admin)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Updated"));
    }

    @Test
    void testGetAllAdmins() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].adminID").value(admin.getAdminID()));
    }

    @Test
    void testDeleteAdmin() throws Exception {
        mockMvc.perform(delete("/admin/1"))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/admin/1"))
                .andExpect(status().isNotFound());
    }

 */
}