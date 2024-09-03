package za.ac.cput.factory;

import za.ac.cput.domain.Buyer;
import za.ac.cput.domain.TransactionHistory;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BuyerFactoryTest {

    @Test
    void testCreateBuyer_ValidInputs() {
        Set<TransactionHistory> buyingHistory = new HashSet<>();

        buyingHistory.add(new TransactionHistory());

        Buyer buyer = BuyerFactory.createBuyer(buyingHistory);

        assertNotNull(buyer);
        assertEquals(buyingHistory, buyer.getBuyingHistory());
    }

    @Test
    void testCreateBuyer_NullInputs() {
        Buyer buyer = BuyerFactory.createBuyer(null);
        assertNull(buyer);
    }

    @Test
    void testCreateBuyer_EmptyBuyingHistory() {
        Buyer buyer = BuyerFactory.createBuyer(new HashSet<>());
        assertNull(buyer);
    }
}

