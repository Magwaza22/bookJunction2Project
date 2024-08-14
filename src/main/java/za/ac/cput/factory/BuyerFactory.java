package za.ac.cput.factory;

import za.ac.cput.domain.Buyer;
import za.ac.cput.util.Helper;

public class BuyerFactory {
    public static Buyer createBuyer(String name, String email, String phoneNumber) {
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber)) {
            return null;
        }

        String buyerId = String.valueOf(Helper.generateId());

        return new Buyer.Builder()
                .setBuyerId(buyerId)
                .setName(name)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .build();
    }
}