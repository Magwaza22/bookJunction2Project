package za.ac.cput.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import za.ac.cput.domain.Listing;

import java.util.List;

public interface IListingService extends IService<Listing, Integer>{
    void delete(int listingID);
    List<Listing> getall();
}
