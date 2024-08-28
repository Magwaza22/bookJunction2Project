package za.ac.cput.factory;

import za.ac.cput.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void testCreateUser_ValidInputs() {
        User user = UserFactory.createUser("user123", "John Doe", "john@example.com", "1234567890");

        assertNotNull(user);
        assertEquals("user123", user.getUserId());
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("1234567890", user.getPhoneNumber());
    }

    @Test
    void testCreateUser_NullUserId() {
        User user = UserFactory.createUser(null, "John Doe", "john@example.com", "1234567890");

        assertNull(user);
    }

    @Test
    void testCreateUser_EmptyName() {
        User user = UserFactory.createUser("user123", "", "john@example.com", "1234567890");

        assertNull(user);
    }

    @Test
    void testCreateUser_NullEmail() {
        User user = UserFactory.createUser("user123", "John Doe", null, "1234567890");

        assertNull(user);
    }

    @Test
    void testCreateUser_NullPhoneNumber() {
        User user = UserFactory.createUser("user123", "John Doe", "john@example.com", null);

        assertNull(user);
    }

    @Test
    void testCreateUser_EmptyUserId() {
        User user = UserFactory.createUser("", "John Doe", "john@example.com", "1234567890");

        assertNull(user);
    }
}