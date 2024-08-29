package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Listing;
import za.ac.cput.repository.ListingRepository;

import java.util.List;
@Service
public class ListingService implements IListingService {
    private final ListingRepository listingRepository;
    @Autowired
    ListingService(ListingRepository listingRepository) {this.listingRepository = listingRepository;}

    @Override
    public Listing create(Listing listing) {return listingRepository.save(listing);}

    @Override
    public Listing read(String string){return listingRepository.findById(string).orElse(null);}

    @Override
    public Listing update(Listing listing) {return listingRepository.save(listing);}


    @Override
    public void delete(String listingID){listingRepository.deleteById(listingID);}

    @Override
    public List<Listing> getall(){return listingRepository.findAll();}

    @Override
    public List<Listing> getAllListings() {
        return List.of();
    }

    @Override
    public void deleteListing(int listingID) {

    }

}
