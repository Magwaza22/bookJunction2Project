package za.ac.cput.service;

import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;
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

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User.Builder()
                .setUserId("user123")
                .setName("John Doe")
                .setEmail("john@example.com")
                .setPhoneNumber("1234567890")
                .build();
    }

    @Test
    void testCreateUser() {
        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.create(user);
        assertNotNull(createdUser);
        assertEquals(user, createdUser);
    }

    @Test
    void testReadUser() {
        when(userRepository.findById("user123")).thenReturn(Optional.of(user));

        User foundUser = userService.read("user123");
        assertNotNull(foundUser);
        assertEquals(user, foundUser);
    }

    @Test
    void testReadUser_NotFound() {
        when(userRepository.findById("user456")).thenReturn(Optional.empty());

        User foundUser = userService.read("user456");
        assertNull(foundUser);
    }

    @Test
    void testUpdateUser() {
        when(userRepository.save(any(User.class))).thenReturn(user);

        User updatedUser = userService.update(user);
        assertNotNull(updatedUser);
        assertEquals(user, updatedUser);
    }

    @Test
    void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);

        List<User> users = userService.getAll();
        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals(user, users.get(0));
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById("user123");

        assertDoesNotThrow(() -> userService.delete("user123"));
        verify(userRepository, times(1)).deleteById("user123");
    }
}