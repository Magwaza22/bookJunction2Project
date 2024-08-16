package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, String> {
    Seller findBySellerId(String sellerId);
    Seller findByEmail(String email);
     void findByUsername(String username);

}
