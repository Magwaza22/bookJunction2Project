package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.BuyerRating;
import za.ac.cput.repository.BuyerRatingRepository;

import java.util.List;

@Service
public class BuyerRatingService implements IBuyerRatingService {


    private BuyerRatingRepository rp;


    @Override
    public BuyerRating create(BuyerRating buyerRating) {
        return rp.save(buyerRating);
    }

    @Override
    public BuyerRating read(Integer integer) {
        return rp.findByOverAllRating(integer);
    }

    @Override
    public BuyerRating update(BuyerRating buyerRating) {
        return rp.save(buyerRating);
    }
    @Override
    public List<BuyerRating> getAll() {
        return rp.findAll();
    }
}
