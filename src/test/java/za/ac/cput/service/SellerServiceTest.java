package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import za.ac.cput.domain.Seller;
import za.ac.cput.service.SellerService;

import static org.junit.jupiter.api.Assertions.*;
@ContextConfiguration
@SpringBootTest // Ensures Spring Boot loads the application context for tests
public class SellerServiceTest {

    @Autowired // Automatically inject the SellerService if using Spring
    private SellerService sellerService;

    private Seller testSeller;

    @BeforeEach
    public void setUp() {
        // Initialize the test data
        testSeller = new Seller();
        testSeller.setId(1L); // Set relevant data
        testSeller.setName("Test Seller");
    }

    @Test
    public void testCreateSeller() {
        // Assuming the SellerService's create method returns the created Seller
        Seller createdSeller = sellerService.create(testSeller);
        assertNotNull(createdSeller);
        assertEquals(testSeller.getName(), createdSeller.getName());
    }

    @Test
    public void testReadSeller() {
        Seller createdSeller = sellerService.create(testSeller);
        Seller foundSeller = sellerService.read(createdSeller.getId());
        assertNotNull(foundSeller);
        assertEquals(createdSeller.getId(), foundSeller.getId());
    }

    @Test
    public void testUpdateSeller() {
        Seller createdSeller = sellerService.create(testSeller);
        createdSeller.setName("Updated Seller");
        Seller updatedSeller = sellerService.update(createdSeller);
        assertEquals("Updated Seller", updatedSeller.getName());
    }

    @Test
    public void testDeleteSeller() {
        Seller createdSeller = sellerService.create(testSeller);
        sellerService.delete(createdSeller.getId());
        Seller foundSeller = sellerService.read(createdSeller.getId());
        assertNull(foundSeller); // Ensure that the seller was deleted
    }

    @Test
    public void testGetAllSellers() {
        sellerService.create(testSeller);
        assertFalse(sellerService.getAll().isEmpty());
    }
}
