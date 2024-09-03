package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;

public class LocationFactoryTest {

    @Test
    void createLocation_ValidAddress_Success() {

        String address = "123 Main St";


        Location location = LocationFactory.createLocation(address);


        assertNotNull(location, "Location should not be null.");
        assertEquals(address, location.getAddress(), "Address should match.");
    }

    @Test
    void createLocation_NullAddress_ThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            LocationFactory.createLocation(null);
        }, "Address cannot be null or empty");
    }

    @Test
    void createLocation_EmptyAddress_ThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            LocationFactory.createLocation("");
        }, "Address cannot be null or empty");
    }

    @Test
    void copyLocation_ValidLocation_Success() {

        Location originalLocation = new Location.Builder()
                .setAddress("456 Elm St")
                .build();


        Location copiedLocation = LocationFactory.copyLocation(originalLocation);


        assertNotNull(copiedLocation, "Copied location should not be null.");
        assertEquals(originalLocation.getAddress(), copiedLocation.getAddress(), "Address should match.");
    }

    @Test
    void copyLocation_NullLocation_ThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            LocationFactory.copyLocation(null);
        }, "Location cannot be null");
    }
}
