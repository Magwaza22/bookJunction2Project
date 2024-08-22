package za.ac.cput.factory;

import za.ac.cput.domain.Seller;
import za.ac.cput.util.Helper;

public class SellerFactory {
    public static Seller createSeller(String firstName, String name, String email, String phoneNumber) {
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber)) {
            return null;
        }

        String sellerId = String.valueOf(Helper.generateId());

        return new Seller.Builder()
                .setSellerId(sellerId)
                .setName(name)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .build();
    }
}