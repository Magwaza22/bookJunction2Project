package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Listing;
@Repository
public interface ListingRepository extends JpaRepository <Listing, Integer>{

}
