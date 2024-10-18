package za.ac.cput.factory;

import za.ac.cput.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void testCreateUser_ValidInputs() {
        User user = UserFactory.createUser("John", "Doe", "john@example.com", "1234567890","Jon#11");
        assertNotNull(user);
        assertNull(user.getUserId());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("1234567890", user.getPhoneNumber());
        assertEquals("Jon#11", user.getPassword());
    }
}

