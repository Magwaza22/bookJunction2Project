package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Buyer;
import za.ac.cput.domain.Seller;
import za.ac.cput.domain.TransactionHistory;

import java.awt.print.Book;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransactionHistoryFactoryTest {

    @Test
    void createTransactionHistory() {
        Book book = new Book(); // Assume Book has a default constructor
        Buyer buyer = new Buyer(); // Assume Buyer has a default constructor
        Seller seller = new Seller(); // Assume Seller has a default constructor
        LocalDate date = LocalDate.now();

        TransactionHistory transactionHistory = TransactionHistoryFactory.createTransactionHistory(1, book, buyer, seller, date);

        assertNotNull(transactionHistory);
        assertEquals(1, transactionHistory. getTransaction_id());
        assertEquals(book, transactionHistory.getBook_id());
        assertEquals(buyer, transactionHistory.getBuyer());
        assertEquals(seller, transactionHistory.getSeller());
        assertEquals(date, transactionHistory.getDate());
    }
}