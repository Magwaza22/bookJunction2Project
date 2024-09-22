package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public  class ListingFactory {
    public static Listing createListing(int listingID, Book book, User userID, LocalDate dateListed, String status) {
        if (Helper.isNullOrEmpty(String.valueOf(listingID)) || Helper.isNullOrEmpty(String.valueOf(book))
                || Helper.isNullOrEmpty(String.valueOf(userID)) || Helper.isNullOrEmpty(String.valueOf(dateListed))
                || Helper.isNullOrEmpty(status)) {
            return null;
        }
        return new Listing.Builder().setListingID(listingID)
                .setBook(book)
                .setUser(userID)
                .setDateListed(dateListed)
                .setStatus(status)
                .build();
    }
}
