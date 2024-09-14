package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    @Test
    void testCreateAdmin_ValidInputs() {
        int adminID = 1;
        String name = "John Doe";
        String email = "john@example.com";
        String password = "securePassword";
        String phoneNumber = "1234567890";

        Admin admin = AdminFactory.createAdmin(adminID, name, email, password, phoneNumber);

        assertNotNull(admin);
        assertEquals(adminID, admin.getAdminID());
        assertEquals(name, admin.getName());
        assertEquals(email, admin.getEmail());
        assertEquals(password, admin.getPassword());
        assertEquals(phoneNumber, admin.getPhoneNumber());
    }
}