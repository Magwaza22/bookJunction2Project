package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ListingFactoryTest {

    @Test
    public void testCreateListing_Success() {
        byte[] bookPhoto = new byte[]{1, 2, 3};
        Author author = new Author.Builder()
                .setFirstName("Joshua")
                .setLastName("Bloch")
                .build();

        Book book = new Book.Builder()
                .setBookPhoto(bookPhoto)
                .setISBN("123-4567891234")
                .setTitle("Effective Java")
                .setEdition("3rd")
                .setAuthor(author)
                .setPrice(49.99)
                .build();

        User user = new User.UserBuilder()
                .setUserId(123)
                .setName("John Doe")
                .setEmail("john@example.com")
                .setPhoneNumber("1234567890")
                .build();

        // Valid listing
        Listing listing = ListingFactory.createListing(1, book, user, LocalDate.now(), "Active");

        // Assert that the listing is created and contains the correct values
        assertNotNull(listing);
        assertEquals(1, listing.getListingID());
        assertEquals(book, listing.getBook());
        assertEquals(user, listing.getUser());
        assertEquals(LocalDate.now(), listing.getDateListed());
        assertEquals("Active", listing.getStatus());
    }

    @Test
    void createListing_Fail() {
        byte[] bookPhoto = new byte[]{1, 2, 3};
        Author author = new Author.Builder()
                .setFirstName("")
                .setLastName("Bloch")
                .build();

        Book book = new Book.Builder()
                .setBookPhoto(bookPhoto)
                .setISBN("123-4567891234")
                .setTitle("Effective Java")
                .setEdition("")
                .setAuthor(author)
                .setPrice(49.99)
                .build();
        User user = new User.UserBuilder()
                .setUserId(123)
                .setName("")
                .setEmail("john@example.com")
                .setPhoneNumber(null)
                .build();

        // Valid listing
        Listing listing = ListingFactory.createListing(1, book, user, LocalDate.now(), "Active");

        // Assert that the listing is created and contains the correct values
        assertNotNull(listing);
        assertEquals(1, listing.getListingID());
        assertEquals(book, listing.getBook());
        assertEquals(user, listing.getUser());
        assertEquals(LocalDate.now(), listing.getDateListed());
        assertEquals("Active", listing.getStatus());
    }
}