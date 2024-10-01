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
    public Listing read(Integer integer){return listingRepository.findById(integer).orElse(null);}

    @Override
    public Listing update(Listing listing) {return listingRepository.save(listing);}


    @Override
    public void delete(Integer listingID){listingRepository.deleteById(listingID);}

    @Override
    public List<Listing> getall(){return listingRepository.findAll();}



}
