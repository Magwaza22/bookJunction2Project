package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Book;
import za.ac.cput.factory.BookFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {
/*
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/bookjunction2Project/book";
    private static Book book;
    private static BookController bookController;

    @BeforeAll
    public static void setUp() {
        byte[] bookPhoto = new byte[]{1, 2, 3};
        book = BookFactory.createBook(4, bookPhoto, "267-3-16-28861-2", "Java Programming", "Third Edition",
                "Ted", "James",  302.99);
    }

    public static void setBookController(BookController bookController) {
        BookControllerTest.bookController = bookController;
    }

    @Test
    void save() {
        String url = BASE_URL + "/create";
        ResponseEntity<Book> postResponse = restTemplate.postForEntity(url, book, Book.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertNotEquals(postResponse.getStatusCode().HttpStatus.OK);
        Book bookSaved = postResponse.getBody();
        //assertEquals(book.getBookID(), bookSaved.getBookID());
        System.out.println("Saved data: " +bookSaved);
    }

    @Test
    void read() {
        String url = BASE_URL + "/read/" + book.getBookID();
        System.out.println("URL:" + url);
        ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);
       // assertEquals(book.getBookID(), response.getBody().getBookID());
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
    @Disabled
    void getAll() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        when(bookController.getAll()).thenReturn(bookList);
        ResponseEntity<List<Book>> response = (ResponseEntity<List<Book>>) bookController.getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        //assertEquals(book, response.getBody().get(0));
    }

 */
}