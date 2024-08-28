package za.ac.cput.service;

import za.ac.cput.domain.Listing;
import za.ac.cput.repository.ListingRepository; // Assume this is your JPA repository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    public Listing getListingById(int id) {
        return listingRepository.findById(id).orElse(null);
    }

    public Listing createListing(Listing listing) {
        return listingRepository.save(listing);
    }

    public Listing updateListing(int id, Listing listing) {
        if (listingRepository.existsById(id)) {
            listing.setListingID(id); // Ensure the ID is set correctly
            return listingRepository.save(listing);
        }
        return null;
    }

    public boolean deleteListing(int id) {
        if (listingRepository.existsById(id)) {
            listingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}