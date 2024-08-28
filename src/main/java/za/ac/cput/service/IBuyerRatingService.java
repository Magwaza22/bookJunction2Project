package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.BuyerRating;
import java.util.List;
@Service
public interface IBuyerRatingService extends IService<BuyerRating, Integer>{
    List <BuyerRating> getAll();
}
