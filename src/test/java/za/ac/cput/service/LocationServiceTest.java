package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.cput.domain.Location;
import za.ac.cput.repository.LocationRepository;
import za.ac.cput.service.LocationService;

import java.util.Optional;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private LocationService locationService;

    private Location location;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        location = new Location.Builder()
                .setAddress("143 Sir Lowry Rd")
                .build();
    }

    @Test
    void update() {
        when(locationRepository.existsById(location.getId())).thenReturn(true);
        when(locationRepository.save(location)).thenReturn(location);

        Location updatedLocation = locationService.update(location);

        assertNotNull(updatedLocation);
        assertEquals(location.getId(), updatedLocation.getId());
        verify(locationRepository, times(1)).existsById(location.getId());
        verify(locationRepository, times(1)).save(location);
    }

    @Test
    void update_NotFound() {
        when(locationRepository.existsById(location.getId())).thenReturn(false);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            locationService.update(location);
        });

        assertEquals("Location not found with id: " + location.getId(), exception.getMessage());
        verify(locationRepository, times(1)).existsById(location.getId());
        verify(locationRepository, times(0)).save(location);
    }

    @Test
    void read() {
        when(locationRepository.findById(location.getId())).thenReturn(Optional.of(location));

        Location foundLocation = locationService.read(location.getId());

        assertNotNull(foundLocation);
        assertEquals(location.getId(), foundLocation.getId());
        verify(locationRepository, times(1)).findById(location.getId());
    }

    @Test
    void read_NotFound() {
        when(locationRepository.findById(location.getId())).thenReturn(Optional.empty());

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            locationService.read(location.getId());
        });

        assertEquals("Location not found with id: " + location.getId(), exception.getMessage());
        verify(locationRepository, times(1)).findById(location.getId());
    }

    @Test
    void delete() {
        when(locationRepository.existsById(location.getId())).thenReturn(true);

        locationService.delete(location.getId());

        verify(locationRepository, times(1)).existsById(location.getId());
        verify(locationRepository, times(1)).deleteById(location.getId());
    }

    @Test
    void delete_NotFound() {
        when(locationRepository.existsById(location.getId())).thenReturn(false);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            locationService.delete(location.getId());
        });

        assertEquals("Location not found with id: " + location.getId(), exception.getMessage());
        verify(locationRepository, times(1)).existsById(location.getId());
        verify(locationRepository, times(0)).deleteById(location.getId());
    }
}