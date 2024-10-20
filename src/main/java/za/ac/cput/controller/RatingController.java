package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Rating;
import za.ac.cput.service.RatingService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating createdRating = ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRating(@PathVariable String id) {
        Rating rating = ratingService.read(Integer.valueOf(id));
        return rating != null ? ResponseEntity.ok(rating) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating) {
        Rating updatedRating = ratingService.update(rating);
        return ResponseEntity.ok(updatedRating);
    }

    @GetMapping("/getall")
    public List<Rating> getAll(){return ratingService.getAll() ;}

}
