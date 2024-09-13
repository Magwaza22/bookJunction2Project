package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookFactoryTest {

    @Test
    void createBook_Success() {
        // Arrange - Set up the necessary parameters
        int bookID = 1;
        byte[] bookPhoto = new byte[]{1, 2, 3};
        String ISBN = "123-4567891234";
        String title = "Effective Java";
        String edition = "3rd";
        String authorFirstName = "Joshua";
        String authorLastName = "Bloch";
        Double price = 49.99;

        Book createdBook = BookFactory.createBook(bookID, bookPhoto, ISBN, title, edition, authorFirstName, authorLastName, price);

        assertNotNull(createdBook);
        assertEquals(bookID, createdBook.getBookID());
        assertArrayEquals(bookPhoto, createdBook.getBookPhoto());
        assertEquals(ISBN, createdBook.getISBN());
        assertEquals(title, createdBook.getTitle());
        assertEquals(edition, createdBook.getEdition());
        assertEquals(authorFirstName, createdBook.getAuthor().getFirstName());
        assertEquals(authorLastName, createdBook.getAuthor().getLastName());
        assertEquals(price, createdBook.getPrice());
    }

    @Test
    void createBook_Fail() {

        int bookID = 0;
        byte[] bookPhoto = null;
        String ISBN = "";
        String title = "";
        String edition = "1st";
        String authorFirstName = "John";
        String authorLastName = "";
        Double price = null;

        Book createdBook = BookFactory.createBook(bookID, bookPhoto, ISBN, title, edition, authorFirstName, authorLastName, price);

        assertNull(createdBook);
    }
}
