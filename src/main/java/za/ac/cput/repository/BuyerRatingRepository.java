package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRatingRepository extends JpaRepository<BuyerRating, Integer> {

    BuyerRating findByOverAllRating(Integer OverAllRating) ;

}
