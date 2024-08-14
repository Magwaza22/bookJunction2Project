package za.ac.cput.factory;

import za.ac.cput.domain.Location;
import za.ac.cput.util.Helper;

public class LocationFactory {
    public static Location createLocation(String address, String contactInformation, String operatingHours, String city) {
        if (Helper.isNullOrEmpty(address) || Helper.isNullOrEmpty(contactInformation) ||
                Helper.isNullOrEmpty(operatingHours) || Helper.isNullOrEmpty(city))
            return null;

        return new Location.Builder()
                .setAddress(address)
                .setContactInformation(contactInformation)
                .setOperatingHours(operatingHours)
                .setCity(city)
                .build();
    }
}
