package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import za.ac.cput.domain.Book;
import za.ac.cput.factory.BookFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class BookServiceTest {
    @Autowired
    private BookService bookService;
    private static Book book1;
    private static Book book2;

    @BeforeEach
    void setUp() {
        byte[] bookPhoto = new byte[]{1, 2, 3};
        book1 = BookFactory.createBook( 1L, bookPhoto, "978-3-16-148410-0", "Harry Potter", "First Edition",
                "J.K.", "Rowling", "jk.rowling@example.com", "123-456-7890",
                "British", 29.99);
        assertNotNull(book1);
        System.out.println(book1);
        book2 = BookFactory.createBook( 2L, bookPhoto, "338-3-16-1383920-2", "Mathematics Beginner", "Third Edition",
                "Shawn", "Smith", "smithS@example.com", "075-477-0029",
                "American", 106.99);
        assertNotNull(book2);
        System.out.println(book2);

    }

    @Test
    void create() {
        Book created1 = bookService.create(book1);
        assertNotNull(created1);
        System.out.println(created1);
        Book created2 = bookService.create(book2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void read() {

        Book foundBook = bookService.read(book1.getBookID());
        assertNotNull(foundBook);
        assertEquals(book1.getBookID(), foundBook.getBookID());
        System.out.println(foundBook);
    }

    @Test
    void update() {
        Book newBook = new Book.Builder().copy(book2).setEdition("Second Edition")
                .build();
        Book updated =bookService.update(newBook);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
        assert book1 != null;
        bookService.delete(book1.getBookID());
        System.out.println("Success: Book deleted ");
    }

    @Test
    void getall() {
        System.out.println(bookService.getall());
    }
}