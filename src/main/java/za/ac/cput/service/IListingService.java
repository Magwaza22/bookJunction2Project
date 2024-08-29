package za.ac.cput.service;

import za.ac.cput.domain.Listing;

import java.util.List;

public interface IListingService extends IService<Listing, String>{
    void delete(String listingID);

    List<Listing> getall();

    List<Listing> getAllListings();
    void deleteListing(int listingID);
}
