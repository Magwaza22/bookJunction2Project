package za.ac.cput.factory;

import za.ac.cput.domain.Seller;
import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.util.Helper;

import java.util.Set;

public class SellerFactory {

    public static Seller createSeller(Set<TransactionHistory> inventory) {
        if (inventory == null || inventory.isEmpty()) {
            return null;
        }

        return new Seller.Builder()
                .setInventory(inventory)
                .build();
    }

    public static Seller buildSeller(Set<TransactionHistory> inventory) {
        throw new UnsupportedOperationException();
    }
}