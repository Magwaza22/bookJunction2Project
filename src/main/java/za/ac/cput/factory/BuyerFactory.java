package za.ac.cput.factory;

import za.ac.cput.domain.Buyer;
import za.ac.cput.util.Helper;

public class BuyerFactory {
    public static Buyer createBuyer(String buyerId, String name, String email, String phoneNumber) {
        if (Helper.isNullOrEmpty(buyerId) || Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber)) {
            return null;
        }

        return new Buyer.Builder()
                .setBuyerId(buyerId)
                .setName(name)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .build();
    }
}
