package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Buyer;
import za.ac.cput.service.BuyerService;

import java.util.List;

@RestController
@RequestMapping("/buyers")
public class BuyerController {

    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @PostMapping
    public ResponseEntity<Buyer> createBuyer(@RequestBody Buyer buyer) {
        Buyer createdBuyer = buyerService.create(buyer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBuyer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getBuyer(@PathVariable Long id) {
        Buyer buyer = buyerService.read(id);
        return buyer != null ? ResponseEntity.ok(buyer) : ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Buyer> updateBuyer(@RequestBody Buyer buyer) {
        Buyer updatedBuyer = buyerService.update(buyer);
        return ResponseEntity.ok(updatedBuyer);
    }

    @GetMapping
    public ResponseEntity<List<Buyer>> getAllBuyers() {
        List<Buyer> buyers = buyerService.getAll();
        return ResponseEntity.ok(buyers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyer(@PathVariable Long id) {
        buyerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}