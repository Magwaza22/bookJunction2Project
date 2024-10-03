package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Listing;
import za.ac.cput.domain.User;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ListingControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/bookjunction2Project/listing";
    private static Listing listing ;
    private static ListingController listingController;
    private Listing testListing;

    @BeforeAll
    public static void setUp() {
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
        // Create and save a test listing
        listing = new Listing.Builder()
                .setListingID(1)
                .setBook(book)
                .setUser(user)
                .setDateListed(LocalDate.now())
                .setStatus("Active")
                .build();
        listingController.save(listing);
    }
        @Test void read() {
            // Send a GET request to read the listing by ID
            ResponseEntity<Listing> response = restTemplate.getForEntity("/read/{id}", Listing.class, listing.getListingID());

            // Validate the response
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
            assertEquals(listing.getListingID(), response.getBody().getListingID());
            assertEquals("Active", response.getBody().getStatus());
        }
        @Test
        void deleteByID() {
            // Send a DELETE request to remove the listing by ID
            restTemplate.delete("/deletebyid/{id}", listing.getListingID());

            // Verify that the listing is deleted
            ResponseEntity<Listing> response = restTemplate.getForEntity("/read/{id}", Listing.class, listing.getListingID());
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNull(response.getBody());  // The listing should not be found
        }
        @Test
        void getAll() {
            // Send a GET request to fetch all listings
            ResponseEntity<List> response = restTemplate.getForEntity("/getall", List.class);

            // Validate the response
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
            assertEquals(1, response.getBody().size());  // We expect 1 listing from the setup
        }

    }




