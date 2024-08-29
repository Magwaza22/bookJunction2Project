package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Book;
import za.ac.cput.factory.BookFactory;

import java.net.http.HttpHeaders;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/bookjunction2Project/book";
    private static Book book;

    @BeforeAll
    public static void setUp() {
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
        String url = BASE_URL + "/read/" + book.getBookID();
        System.out.println("URL:" + url);
        ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);
        assertEquals(book.getBookID(), response.getBody().getBookID());
        System.out.println("Read: " + response.getBody());

    }

    @Test
    void deleteByID() {
        String url = BASE_URL + "/delete/" + book.getBookID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Deleted book");
    }

    @Test
    void getAll() {
       /* String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());*/
    }
}