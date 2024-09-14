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

}
