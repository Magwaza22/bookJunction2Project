package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Seller;
import za.ac.cput.service.ISellerService;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    private final ISellerService sellerService;

    @Autowired
    public SellerController(ISellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping
    public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) {
        Seller createdSeller = sellerService.create(seller);
        return ResponseEntity.ok(createdSeller);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id) {
        Seller seller = sellerService.read(id);
        return seller != null ? ResponseEntity.ok(seller) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Seller>> getAllSellers() {
        List<Seller> sellers = sellerService.getAll();
        return ResponseEntity.ok(sellers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller seller) {
        seller.setId(id); // Set the ID for the update
        Seller updatedSeller = sellerService.update(seller);
        return ResponseEntity.ok(updatedSeller);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        sellerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}