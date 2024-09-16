package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
    private User user;

    @BeforeEach
    void setUp() {
        user = new User.UserBuilder()
                .setUserId(1234)
                .setName("John Doe")
                .setEmail("john@example.com")
                .setPhoneNumber("1234567890")
                .build();
    }
    @Test
    public void createUser(){
        User createdUser = userService.create(user);
        assertNotNull(createdUser);
        System.out.println(createdUser);
    }
}

