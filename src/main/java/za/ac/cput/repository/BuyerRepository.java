package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, String> {


}

