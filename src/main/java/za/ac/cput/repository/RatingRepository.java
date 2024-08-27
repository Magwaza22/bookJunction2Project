package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.CustomerRating;

@Repository
public interface RatingRepository extends JpaRepository<CustomerRating, Integer> {

    CustomerRating findByOverAllRating(Integer OverAllRating) ;

}
