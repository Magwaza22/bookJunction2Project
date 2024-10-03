package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class TransactionHistoryFactoryTest {

    @Test
    void createTransactionHistory_Success() {

        int transactionID = 123;

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
        LocalDate date = LocalDate.of(2018, 1, 1);

        TransactionHistory transactionHistory = TransactionHistoryFactory.createTransactionHistory(transactionID, book, user, date );

        assertNotNull(transactionHistory);
        assertEquals(transactionID, transactionHistory.getTransactionID());
        assertEquals(book, transactionHistory.getBookID());
        assertEquals(user, transactionHistory.getUser());
        assertEquals(date, transactionHistory.getDate());
    }

    @Test
    void createTransactionHistory_Fail() {
        int transactionID = 0;
        byte[] bookPhoto = new byte[]{1, 2, 3};
        Author author = new Author.Builder()
                .setFirstName(null)
                .setLastName(null)
                .build();

        Book book = new Book.Builder()
                .setBookPhoto(bookPhoto)
                .setISBN(null)
                .setTitle("")
                .setEdition("")
                .setAuthor(author)
                .setPrice(49.99)
                .build();

        User user = new User.UserBuilder()
                .setUserId(123)
                .setName("")
                .setEmail("john@example.com")
                .setPhoneNumber("1234567890")
                .build();

        LocalDate date = LocalDate.of(2018, 1, 1);

        TransactionHistory transactionHistory = TransactionHistoryFactory.createTransactionHistory(transactionID, book, user, date );

        assertNotNull(transactionHistory);
        assertEquals(transactionID, transactionHistory.getTransactionID());
        assertEquals(book, transactionHistory.getBookID());
        assertEquals(user, transactionHistory.getUser());
    assertEquals(date, transactionHistory.getDate());
    }
}