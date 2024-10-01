package za.ac.cput.service;

import za.ac.cput.domain.Listing;

import java.util.List;

public interface IListingService <Listing,Integer >{

    za.ac.cput.domain.Listing read(java.lang.Integer integer);

    za.ac.cput.domain.Listing update(za.ac.cput.domain.Listing listing);

    void delete(java.lang.Integer listingID);

    List<za.ac.cput.domain.Listing> getall();
}
