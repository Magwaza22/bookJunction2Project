package za.ac.cput.service;

import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
        user = new User.Builder()
                .setUserId("user123")
                .setName("John Doe")
                .setEmail("john@example.com")
                .setPhoneNumber("1234567890")
                .build();
    }

    @Test
    void testCreateUser() {
        User createdUser = userService.create(user);
        assertNotNull(createdUser);
        assertEquals(user.getUserId(), createdUser.getUserId());
    }

    @Test
    void testReadUser() {
        userRepository.save(user);
        User foundUser = userService.read("user123");
        assertNotNull(foundUser);
        assertEquals(user.getUserId(), foundUser.getUserId());
    }

    @Test
    void testReadUser_NotFound() {
        User foundUser = userService.read("user456");
        assertNull(foundUser);
    }

    @Test
    void testUpdateUser() {
        userRepository.save(user);
        user.getName("Jane Doe");
        User updatedUser = userService.update(user);
        assertNotNull(updatedUser);
        assertEquals("Jane Doe", updatedUser.getName("Jane Doe"));
    }

    @Test
    void testGetAllUsers() {
        userRepository.save(user);
        List<User> users = userService.getAll();
        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals(user.getUserId(), users.get(0).getUserId());
    }

    @Test
    void testDeleteUser() {
        userRepository.save(user);
        assertDoesNotThrow(() -> userService.delete("user123"));
        assertFalse(userRepository.existsById("user123"));
    }
}