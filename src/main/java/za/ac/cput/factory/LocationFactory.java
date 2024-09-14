package za.ac.cput.factory;

import za.ac.cput.domain.Location;
import za.ac.cput.util.Helper;

public class LocationFactory {

    public static Location buildLocation(String address) {

        if (Helper.isNullOrEmpty(address)) {
            return null;
        }

        return new Location.Builder()
                .setAddress(address)
                .build();
    }
}
