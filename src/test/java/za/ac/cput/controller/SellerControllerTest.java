package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Seller;
import za.ac.cput.service.ISellerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class SellerControllerTest {

    @InjectMocks
    private SellerController sellerController;

    @Mock
    private ISellerService sellerService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    void testCreateSeller() throws Exception {
        Seller seller = new Seller(); // Initialize with required fields
        when(sellerService.create(any(Seller.class))).thenReturn(seller);

        ResponseEntity<Seller> response = sellerController.createSeller(seller);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(seller, response.getBody());
    }

    @Test
    void testGetSellerById() throws Exception {
        Seller seller = new Seller(); // Initialize with required fields
        when(sellerService.read(anyLong())).thenReturn(seller);

        ResponseEntity<Seller> response = sellerController.getSellerById(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(seller, response.getBody());
    }

    @Test
    void testGetSellerById_NotFound() throws Exception {
        when(sellerService.read(anyLong())).thenReturn(null);

        ResponseEntity<Seller> response = sellerController.getSellerById(1L);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testGetAllSellers() throws Exception {
        List<Seller> sellers = new ArrayList<>();
        when(sellerService.getAll()).thenReturn(sellers);

        ResponseEntity<List<Seller>> response = sellerController.getAllSellers();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(sellers, response.getBody());
    }

//    @Test
//    void testUpdateSeller() throws Exception {
//        Seller seller = new Seller(); // Initialize with required fields
//        when(sellerService.update(any(Seller.class))).thenReturn(seller);
//
//        ResponseEntity<Seller> response = sellerController.updateSeller(1L, seller);
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(seller, response.getBody());
//    }

//    @Test
//    void testDeleteSeller() throws Exception {
//        doNothing().when(sellerService).delete(anyLong());
//
//        ResponseEntity<Void> response = sellerController.deleteSeller(1L);
//        assertEquals(204, response.getStatusCodeValue());
//    }
}