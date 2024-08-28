package za.ac.cput.controller;

import za.ac.cput.domain.Buyer;
import za.ac.cput.service.BuyerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BuyerControllerTest {

    @Mock
    private BuyerService buyerService;

    @InjectMocks
    private BuyerController buyerController;

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
        when(buyerService.create(any(Buyer.class))).thenReturn(buyer);

        ResponseEntity<Buyer> response = buyerController.createBuyer(buyer);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(buyer, response.getBody());
    }

    @Test
    void testGetBuyer() {
        when(buyerService.read(1L)).thenReturn(buyer);

        ResponseEntity<Buyer> response = buyerController.getBuyer(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(buyer, response.getBody());
    }

    @Test
    void testGetBuyer_NotFound() {
        when(buyerService.read(2L)).thenReturn(null);

        ResponseEntity<Buyer> response = buyerController.getBuyer(2L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testUpdateBuyer() {
        when(buyerService.update(any(Buyer.class))).thenReturn(buyer);

        ResponseEntity<Buyer> response = buyerController.updateBuyer(buyer);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(buyer, response.getBody());
    }

    @Test
    void testGetAllBuyers() {
        List<Buyer> buyerList = new ArrayList<>();
        buyerList.add(buyer);
        when(buyerService.getAll()).thenReturn(buyerList);

        ResponseEntity<List<Buyer>> response = buyerController.getAllBuyers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(buyer, response.getBody().get(0));
    }

    @Test
    void testDeleteBuyer() {
        doNothing().when(buyerService).delete(1L);

        ResponseEntity<Void> response = buyerController.deleteBuyer(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(buyerService, times(1)).delete(1L);
    }
}