package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Book;

import static org.junit.jupiter.api.Assertions.*;

public class BookFactoryTest {

    @Test
    public void testCreateBook_Successful() {
        byte[] bookPhoto = new byte[]{1, 2, 3};

        Book book = BookFactory.createBook(
                1L,
                bookPhoto,
                "978-3-16-148410-0",
                "Harry Potter",
                "First Edition",
                "J.K.",
                "Rowling",
                "jk.rowling@example.com",
                "123-456-7890",
                "British",
                29.99
        );

        assertNotNull(book);
        assertEquals(1L, book.getBookID());
        assertArrayEquals(bookPhoto, book.getBookPhoto());
        assertEquals("978-3-16-148410-0", book.getISBN());
        assertEquals("Harry Potter", book.getTitle());
        assertEquals("First Edition", book.getEdition());
        assertNotNull(book.getAuthor());
        assertEquals("J.K.", book.getAuthor().getFirstName());
        assertEquals("Rowling", book.getAuthor().getLastName());
        assertEquals("jk.rowling@example.com", book.getAuthor().getEmail());
        assertEquals("123-456-7890", book.getAuthor().getPhoneNumber());
        assertEquals("British", book.getAuthor().getNationality());
        assertEquals(29.99, book.getPrice());
    }
}

