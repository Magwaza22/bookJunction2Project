package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Book;
import za.ac.cput.factory.BookFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/book_junction/book";
    private static Book book;

    @BeforeEach
    void setUp() {
        byte[] bookPhoto = new byte[]{1, 2, 3};
        book = BookFactory.createBook(3L, bookPhoto, "267-3-16-28861-2", "Java Programming", "Third Edition",
                "Ted", "James", "jamesT@example.com", "089-289-6729",
                "British", 302.99);
    }

    @Test
    void save() {
        String url = BASE_URL + "/create";
        ResponseEntity<Book> postResponse = restTemplate.postForEntity(url, book, Book.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertNotEquals(postResponse.getStatusCode().HttpStatus.OK);
        Book bookSaved = postResponse.getBody();
        assertEquals(book.getBookID(), bookSaved.getBookID());
        System.out.println("Saved data: " +bookSaved);
    }

    @Test
    void read() {

    }

    @Test
    void deleteByID() {
    }

    @Test
    void getAll() {
    }
}