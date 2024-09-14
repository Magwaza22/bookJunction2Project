package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Rating;
import za.ac.cput.domain.User;
import za.ac.cput.repository.RatingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService implements IRatingService{


    @Autowired
    public RatingRepository rrepo;

    @Override
    public Rating create(Rating rating) {
        return rrepo.save(rating);
    }

    @Override
    public Rating read(Long id) {
        return rrepo.findById(id).orElseThrow();
    }


    @Override
    public Rating update(Rating rating) {
        return rrepo.save(rating);
    }


    @Override
    public List<Rating> getAll() {
        return rrepo.findAll();
    }
}
