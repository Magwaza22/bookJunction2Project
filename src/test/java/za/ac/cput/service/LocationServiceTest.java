package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.repository.LocationRepository;
import za.ac.cput.service.LocationService;

import java.util.Optional;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LocationServiceTest {

    @Autowired
    private LocationService locationService;
    private Location location;

    @BeforeEach
    public void setup(){
        location = LocationFactory.createLocation("143 Sir Lowry Rd, Cape Town, 8000");
    }

    @Test
    @Order(1)
    public void createLocation(){
        Location createdLocation = locationService.create(location);
        assertNotNull(createdLocation);
        System.out.println(createdLocation);
    }
}
