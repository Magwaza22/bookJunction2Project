package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Listing;

public interface OrderRepository extends JpaRepository<Listing, String> {

}
