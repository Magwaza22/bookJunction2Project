package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Location;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class LocationFactoryTest {

    @Test
    void testBuildLocation() {

        String address = "123 Main St";
        Location location = LocationFactory.buildLocation(address);
        assertNotNull(location);

        assertEquals(address, location.getAddress());
        System.out.println(location.toString());
    }

    @Test
    void testBuildLocationWithFail() {
        Location location = LocationFactory.buildLocation(null);

        assertNull(location);

        System.out.println("Test with null address: " + location);
    }
}