package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.CustomerRating;
import za.ac.cput.repository.RatingRepository;

import java.util.List;

@Service
public class RatingService implements IRatingService{


    private RatingRepository rp;


    @Override
    public CustomerRating create(CustomerRating customerRating) {
        return rp.save(customerRating);
    }

    @Override
    public CustomerRating read(Integer integer) {
        return rp.findByOverAllRating(integer);
    }

    @Override
    public CustomerRating update(CustomerRating customerRating) {
        return rp.save(customerRating);
    }
    @Override
    public List<CustomerRating> getAll() {
        return rp.findAll();
    }
}
