package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Book;
import za.ac.cput.factory.BookFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class BookServiceTest {
    @Autowired
    private BookService bookService;

    private static Book book1, book2,book3;

    @BeforeEach
    void setUp() {
        byte[] bookPhoto = new byte[]{1, 2, 3};
        book1 = BookFactory.createBook( 1, bookPhoto, "978-3-16-148410-0", "Harry Potter", "First Edition",
                "J.K.", "Rowling",  29.99);
        assertNotNull(book1);
        System.out.println(book1);
        book2 = BookFactory.createBook( 2, bookPhoto, "338-3-16-1383920-2", "Mathematics Beginner", "Third Edition",
                "Shawn", "Smith",  106.99);
        assertNotNull(book2);
        System.out.println(book2);
        book3 = BookFactory.createBook( 3, bookPhoto, "338-3-16-138370-2", "Effective Java", "3rd Edition",
                "Joshua", "Bloch",  78.99);
        assertNotNull(book3);
        System.out.println(book3);

    }

    @Test
    void create() {
        Book created1 = bookService.create(book1);
        assertNotNull(created1);
        System.out.println(created1);
        Book created2 = bookService.create(book2);
        assertNotNull(created2);
        System.out.println(created2);
        Book created3 = bookService.create(book3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void read() {

        assert book1 != null;
        Book read = bookService.read(book1.getBookID());
        //assertNotNull(read);
        System.out.println(read);

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