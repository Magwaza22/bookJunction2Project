package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Rating;
import za.ac.cput.service.RatingService;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating createdRating = ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRating(@PathVariable String id) {
        Rating rating = ratingService.read(Integer.valueOf(id));
        return rating != null ? ResponseEntity.ok(rating) : ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating) {
        Rating updatedRating = ratingService.update(rating);
        return ResponseEntity.ok(updatedRating);
    }

   // @GetMapping
   // public ResponseEntity<List<Rating>> getAllRatings() {
     //   List<Rating> ratings = ratingService.getAll();
    //    return ResponseEntity.ok(ratings);
  //  }

}
