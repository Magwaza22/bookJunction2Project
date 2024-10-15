package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.ListingFactory;
import za.ac.cput.factory.TransactionHistoryFactory;
import za.ac.cput.repository.TransactionHistoryRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class TransactionHistoryServiceTest {
  /*  @Autowired
    private TransactionHistoryService transactionHistoryService;

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    private TransactionHistory testTransaction;

    @BeforeEach
    void setUp() {
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
        testTransaction = new TransactionHistory.Builder()
                .setTransactionID(1)
                .setDate(LocalDate.now())
                .build();

        // Save the initial transaction to the repository
        transactionHistoryRepository.save(testTransaction);

    }
    @Test
    void create() {
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
        TransactionHistory newTransaction = new TransactionHistory.Builder()
                .setTransactionID(2)
                .setDate(LocalDate.now())
                .build();

        TransactionHistory createdTransaction = transactionHistoryService.create(newTransaction);
    }

    @Test
    void read (){
        // Read the existing transaction
        TransactionHistory retrievedTransaction = transactionHistoryService.read(testTransaction.getTransactionID());

        // Assert that the transaction is retrieved and the details are correct
        assertNotNull(retrievedTransaction);
        assertEquals(testTransaction.getTransactionID(), retrievedTransaction.getTransactionID());
        assertEquals("Test transaction", retrievedTransaction.getDate());
    }
    @Test
    void update() {
        // Update the description of the existing transaction
        TransactionHistory newTransactionHistory = new TransactionHistory.Builder().copy(testTransaction).setBookID(24).build();
        TransactionHistory updatedTransaction = transactionHistoryService.update(testTransaction);


    }*/
}