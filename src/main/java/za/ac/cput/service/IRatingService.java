package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Rating;
import java.util.List;
@Service
public interface IRatingService extends IService<Rating, Integer>{
    List <Rating> getAll();
}
