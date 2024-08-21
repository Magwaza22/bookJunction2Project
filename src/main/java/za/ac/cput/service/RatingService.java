package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Rating;
import za.ac.cput.repository.RatingRepository;

import java.util.List;

@Service
public class RatingService implements IRatingService{


    private RatingRepository rp;


    @Override
    public Rating create(Rating rating) {
        return rp.save(rating);
    }

    @Override
    public Rating read(Integer integer) {
        return rp.findByOverAllRating(integer);
    }

    @Override
    public Rating update(Rating rating) {
        return rp.save(rating);
    }
    @Override
    public List<Rating> getAll() {
        return rp.findAll();
    }
}
