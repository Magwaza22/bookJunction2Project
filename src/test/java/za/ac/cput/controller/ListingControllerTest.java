package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import za.ac.cput.domain.Listing;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ListingControllerTest {

    @Autowired
    private TestRestTemplate;
    private final String BASE_URL = "http://localhst:8080?bookjunction2Project/listing";
    private static Listing listing;
    private static ListingController listingController

}