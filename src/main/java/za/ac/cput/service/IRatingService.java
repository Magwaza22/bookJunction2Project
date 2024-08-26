package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.CustomerRating;
import java.util.List;
@Service
public interface IRatingService extends IService<CustomerRating, Integer>{
    List <CustomerRating> getAll();
}
