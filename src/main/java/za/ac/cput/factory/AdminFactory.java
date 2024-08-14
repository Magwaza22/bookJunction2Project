package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.util.Helper;

public class AdminFactory {

    public static Admin createAdmin(Long adminID, String name, String email, String password, String phoneNumber) {
        if (Helper.isNullOrEmpty(String.valueOf(adminID)) || Helper.isNullOrEmpty(name)
                || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(phoneNumber)) {
            return null;
        }
        String AdminId = String.valueOf(Helper.generateId());

        return new Admin.Builder()
                .setAdminID(adminID)
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .setPhoneNumber(phoneNumber)
                .build();
    }
}