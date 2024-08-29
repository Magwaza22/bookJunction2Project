package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Listing;

public interface NotificationRepository extends JpaRepository<Listing, String> {
}
