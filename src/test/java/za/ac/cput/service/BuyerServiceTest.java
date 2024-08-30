package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Buyer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuyerServiceTest {

    @Autowired
    private BuyerService buyerService;

    private Buyer buyer;

    @BeforeEach
    void setUp() {
        buyer = new Buyer.Builder()
                .setBuyingHistory(new HashSet<>()) // Assume TransactionHistory has a default constructor
                .build();
    }

    @Test
    void testCreateBuyer() {
        Buyer createdBuyer = buyerService.create(buyer);
        assertNotNull(createdBuyer);
        assertEquals(buyer, createdBuyer);
    }
}