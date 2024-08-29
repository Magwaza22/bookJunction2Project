package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Listing;
import za.ac.cput.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ListingFactoryTest {

    @Test
    void createListing() {

            Book book = new Book(); // Assume Book has a default constructor
            User user = new User(); // Assume User has a default constructor
            LocalDate dateListed = LocalDate.now();
            Double price = 29.99;
            String status = "Available";
            String condition = "New";

            Listing listing = ListingFactory.createListing(1, book, user, dateListed, price, status, condition);

            assertNotNull(listing);
            assertEquals(1, listing.getListingID());
            assertEquals(book, listing.getBook());
            assertEquals(user, listing.getUser());
            assertEquals(dateListed, listing.getDateListed());
            assertEquals(price, listing.getPrice());
            assertEquals(status, listing.getStatus());
            assertEquals(condition, listing.getCondition());
        }

        @Test
        void testCreateListing_InvalidInput() {
            Listing listing = ListingFactory.createListing(0, null, null, null, null, null, null);
            assertNull(listing);
        }
    }
