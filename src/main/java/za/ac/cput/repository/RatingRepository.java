package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Rating;

import java.util.Optional;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    Optional<Rating> findById(int id);
}
