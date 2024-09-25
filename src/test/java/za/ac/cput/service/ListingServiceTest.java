package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Listing;
import za.ac.cput.domain.User;
import za.ac.cput.factory.ListingFactory;
import za.ac.cput.repository.ListingRepository;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ListingServiceTest {
    @Autowired
    private ListingService listingService;

    @Autowired
    private ListingRepository listingRepository;

    private Listing testListing;

    @BeforeEach
    void setUp() {
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
        testListing = new Listing.Builder()
                .setListingID(1)
                .setBook(book)
                .setUser(user)
                .setDateListed(LocalDate.now())
                .setStatus("Active")
                .build();
        listingRepository.save(testListing);

    }
    @Test
    void read (){
        Listing retrievedListing = listingService.read(testListing.getListingID());
        assertNotNull(retrievedListing);
        assertEquals(testListing.getListingID(), retrievedListing.getListingID());
        assertEquals("Active", retrievedListing.getStatus());
    }
    @Test
    void update (){
        // Update the status of the listing
        Listing newListing = new Listing.Builder().copy(testListing).setStatus("Inactive").build();
        Listing updatedListing = listingService.update(newListing);

        // Check if the listing was updated correctly
        assertNotNull(updatedListing);
        assertEquals("Inactive", updatedListing.getStatus());
    }
    @Test
    void delete() {
        // Delete the listing
        listingService.delete(testListing.getListingID());

    }
    @Test
    void getall() {
        System.out.println(listingService.getall());
    }
}