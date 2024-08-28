package za.ac.cput.service;

import za.ac.cput.domain.Buyer;
import za.ac.cput.repository.BuyerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BuyerServiceTest {

    @Mock
    private BuyerRepository buyerRepository;

    @InjectMocks
    private BuyerService buyerService;

    private Buyer buyer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        buyer = new Buyer.Builder()
                .setBuyingHistory(new HashSet<>()) // Assume TransactionHistory has a default constructor
                .build();
    }

    @Test
    void testCreateBuyer() {
        when(buyerRepository.save(any(Buyer.class))).thenReturn(buyer);

        Buyer createdBuyer = buyerService.create(buyer);
        assertNotNull(createdBuyer);
        assertEquals(buyer, createdBuyer);
    }

    @Test
    void testReadBuyer() {
        when(buyerRepository.findById(String.valueOf(1L))).thenReturn(Optional.of(buyer));

        Buyer foundBuyer = buyerService.read(1L);
        assertNotNull(foundBuyer);
        assertEquals(buyer, foundBuyer);
    }

    @Test
    void testReadBuyer_NotFound() {
        when(buyerRepository.findById(String.valueOf(2L))).thenReturn(Optional.empty());

        Buyer foundBuyer = buyerService.read(2L);
        assertNull(foundBuyer);
    }

    @Test
    void testUpdateBuyer() {
        when(buyerRepository.save(any(Buyer.class))).thenReturn(buyer);

        Buyer updatedBuyer = buyerService.update(buyer);
        assertNotNull(updatedBuyer);
        assertEquals(buyer, updatedBuyer);
    }

    @Test
    void testGetAllBuyers() {
        List<Buyer> buyerList = new ArrayList<>();
        buyerList.add(buyer);
        when(buyerRepository.findAll()).thenReturn(buyerList);

        List<Buyer> allBuyers = buyerService.getAll();
        assertNotNull(allBuyers);
        assertEquals(1, allBuyers.size());
        assertEquals(buyer, allBuyers.get(0));
    }

    @Test
    void testDeleteBuyer() {
        doNothing().when(buyerRepository).deleteById(String.valueOf(1L));

        assertDoesNotThrow(() -> buyerService.delete(1L));
        verify(buyerRepository, times(1)).deleteById(String.valueOf(1L));
    }
}