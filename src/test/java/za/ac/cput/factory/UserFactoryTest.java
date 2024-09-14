package za.ac.cput.factory;

import za.ac.cput.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void testCreateUser_ValidInputs() {
        User user = UserFactory.createUser(123, "John Doe", "john@example.com", "1234567890");

        assertNotNull(user);
        assertEquals(123, user.getUserId());
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("1234567890", user.getPhoneNumber());
    }
}