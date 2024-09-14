package za.ac.cput.factory;

import za.ac.cput.domain.Seller;
import za.ac.cput.domain.TransactionHistory;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SellerFactoryTest {

    @Test
    void testCreateSeller_WithValidData() {
        Set<TransactionHistory> inventory = new HashSet<>();
        inventory.add(new TransactionHistory()); // Add a sample TransactionHistory

        Seller seller = SellerFactory.createSeller(inventory);
        assertNotNull(seller);
        assertEquals(inventory, seller.getInventory());
    }

}