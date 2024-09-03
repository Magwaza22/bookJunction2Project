package za.ac.cput.factory;

import za.ac.cput.domain.Location;

public class LocationFactory {

    public static Location createLocation(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        return new Location.Builder()
                .setAddress(address)
                .build();
    }

    public static Location copyLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }
        return new Location.Builder()
                .copy(location)
                .build();
    }
}
