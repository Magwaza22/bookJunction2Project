package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.util.Helper;

public class AdminFactory {

    public static Admin createAdmin(Integer adminID, String name, String email, String password, String phoneNumber) {

        if (adminID == null || adminID <= 0) {
            throw new IllegalArgumentException("Invalid Admin ID");
        }

        if (Helper.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Admin name is required");
        }

        if (Helper.isNullOrEmpty(email) || !Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Valid email is required");
        }

        if (Helper.isNullOrEmpty(password) || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        if (Helper.isNullOrEmpty(phoneNumber)) {
            throw new IllegalArgumentException("Valid phone number is required");
        }

        return new Admin.Builder()
                .setAdminID(adminID)
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .setPhoneNumber(phoneNumber)
                .build();
    }

    public static Admin buildAdmin(Long adminID, String name, String email, String password, String phoneNumber) {
        throw new UnsupportedOperationException("This method is not implemented yet.");
    }
}
