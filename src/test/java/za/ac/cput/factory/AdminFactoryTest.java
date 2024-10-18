package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    @Test
    void testCreateAdmin_ValidInputs() {
        Integer adminID = Math.toIntExact(Long.valueOf(1));
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

    @Test
    void testCreateAdmin_NullInputs() {
        Admin admin = AdminFactory.createAdmin(null, null, null, null, null);
        assertNull(admin);
    }

    @Test
    void testCreateAdmin_EmptyName() {
        Admin admin = AdminFactory.createAdmin(1, "", "john@example.com", "securePassword", "1234567890");
        assertNull(admin);
    }

    @Test
    void testCreateAdmin_EmptyEmail() {
        Admin admin = AdminFactory.createAdmin(1, "John Doe", "", "securePassword", "1234567890");
        assertNull(admin);
    }

    @Test
    void testCreateAdmin_EmptyPassword() {
        Admin admin = AdminFactory.createAdmin(1, "John Doe", "john@example.com", "", "1234567890");
        assertNull(admin);
    }

    @Test
    void testCreateAdmin_EmptyPhoneNumber() {
        Admin admin = AdminFactory.createAdmin(1, "John Doe", "john@example.com", "securePassword", "");
        assertNull(admin);
    }


}