package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import za.ac.cput.domain.Seller;
import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.repository.SellerRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class SellerServiceTest {

    @InjectMocks
    private SellerService sellerService;

    private SellerRepository sellerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateSeller() {
        Seller seller = new Seller();
        when(sellerRepository.save(any(Seller.class))).thenReturn(seller);

        Seller createdSeller = sellerService.create(seller);
        assertNotNull(createdSeller);
    }

    @Test
    void testReadSeller() {
        Seller seller = new Seller();
        when(sellerRepository.findById(String.valueOf(anyLong()))).thenReturn(Optional.of(seller));

        Seller foundSeller = sellerService.read(1L);
    }

    @Test
    void testReadSeller_NotFound() {
        when(sellerRepository.findById(String.valueOf(anyLong()))).thenReturn(Optional.empty());

        Seller foundSeller = sellerService.read(1L);
        assertNull(foundSeller);
    }

    @Test
    void testUpdateSeller() {
        Seller seller = new Seller();
        when(sellerRepository.save(any(Seller.class))).thenReturn(seller);

        Seller updatedSeller = sellerService.update(seller);
        assertNotNull(updatedSeller);
    }

    @Test
    void testDeleteSeller() {
        doNothing().when(sellerRepository).deleteById(String.valueOf(anyLong()));

        assertDoesNotThrow(() -> sellerService.delete(1L));
        verify(sellerRepository, times(1)).deleteById(String.valueOf(1L));
    }


    @Test
    void testGetAllSellers() {
        List<Seller> sellers = new ArrayList<>();
        when(sellerRepository.findAll()).thenReturn(sellers);

        List<Seller> foundSellers = sellerService.getAll();
        assertEquals(sellers, foundSellers);
    }

}


