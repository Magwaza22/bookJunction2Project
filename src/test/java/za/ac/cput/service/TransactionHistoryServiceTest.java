package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransactionHistoryServiceTest {

    private final BuyerService buyerService;
    private final SellerService sellerService;
    private final BookService bookService;
    private final TransactionHistoryService historyService;
    @Autowired
    public TransactionHistoryServiceTest(BuyerService buyerService, SellerService sellerService, BookService bookService, TransactionHistoryService historyService) {
        this.buyerService = buyerService;
        this.sellerService = sellerService;
        this.bookService = bookService;
        this.historyService = historyService;
    }

    private Book book1;
    private Author author;
    private Buyer buyer1;
    private Seller seller1;
    private TransactionHistory transactionHistory;

    @BeforeEach
    void setup(){
        byte[] bookPhoto = new byte[]{1, 2, 3};
        author = new Author.Builder().setFirstName("Anthony").setLastName("Russo").build();
        book1 = new Book.Builder().setBookPhoto(bookPhoto).setISBN("978-3-16").setTitle("Avengers:Endgame").setEdition("1st Edition").setAuthor(author).setPrice(1200.00).build();
        bookService.create(book1);

        seller1 = (Seller) new Seller.Builder().setName("Lucky").setEmail("lucky@gmail.com").setPhoneNumber("0657897689").build();
        sellerService.create(seller1);

        buyer1 = (Buyer) new Buyer.Builder().setName("Zisanda").setEmail("zish@gmail.com").setPhoneNumber("0798765897").build();
        buyerService.create(buyer1);

        transactionHistory = new TransactionHistory.Builder().setTransaction_id(432).setBook_id(book1).setBuyer(buyer1).setSeller(seller1).setDate(LocalDate.now()).build();

    }

    @Test
    void create() {
        TransactionHistory createdTrans = historyService.create(transactionHistory);
        System.out.println(createdTrans);
    }

    @Test
    void read() {
    }

    @Test
    void update() {

    }
}