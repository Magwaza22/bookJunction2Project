package za.ac.cput.controller;

import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

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
        when(userService.create(any(User.class))).thenReturn(user);

        ResponseEntity<User> response = userController.createUser(user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void testGetUser() {
        when(userService.read("user123")).thenReturn(user);

        ResponseEntity<User> response = userController.getUser("user123");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void testGetUser_NotFound() {
        when(userService.read("user456")).thenReturn(null);

        ResponseEntity<User> response = userController.getUser("user456");

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testUpdateUser() {
        when(userService.update(any(User.class))).thenReturn(user);

        ResponseEntity<User> response = userController.updateUser(user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userService.getAll()).thenReturn(userList);

        ResponseEntity<List<User>> response = userController.getAllUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(user, response.getBody().get(0));
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userService).delete("user123");

        ResponseEntity<Void> response = userController.deleteUser("user123");

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(userService, times(1)).delete("user123");
    }
}