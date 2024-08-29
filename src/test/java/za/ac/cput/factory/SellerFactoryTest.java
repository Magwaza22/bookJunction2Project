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

    @Test
    void testCreateSeller_WithEmptyInventory() {
        Set<TransactionHistory> inventory = new HashSet<>();

        Seller seller = SellerFactory.createSeller(inventory);
        assertNull(seller);
    }

    @Test
    void testCreateSeller_WithNullInventory() {
        Seller seller = SellerFactory.createSeller(null);
        assertNull(seller);
    }

    @Test
    void testBuildSeller_ShouldThrowException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            SellerFactory.buildSeller(new HashSet<>());
        });
    }
}