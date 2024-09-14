package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.repository.SellerRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SellerServiceTest {

    private final BuyerService buyerService;
    private final SellerService sellerService;
    private final BookService bookService;
    private final TransactionHistoryService historyService;
    @Autowired
    public SellerServiceTest(BuyerService buyerService, SellerService sellerService, BookService bookService, TransactionHistoryService historyService) {
        this.buyerService = buyerService;
        this.sellerService = sellerService;
        this.bookService = bookService;
        this.historyService = historyService;
    }

    private Book book1;
    private Author author;
    private Buyer buyer1;
    private Seller seller1;

    @BeforeEach
    void setUp() {
        byte[] bookPhoto = new byte[]{1, 2, 3};
        author = new Author.Builder().setFirstName("Anthony").setLastName("Russo").build();
        book1 = new Book.Builder().setBookPhoto(bookPhoto).setISBN("978-3-16").setTitle("Avengers:Endgame").setEdition("1st Edition").setAuthor(author).setPrice(1200.00).build();
        bookService.create(book1);

        seller1 = (Seller) new Seller.Builder().setName("Lucky").setEmail("lucky@gmail.com").setPhoneNumber("0657897689").build();
        sellerService.create(seller1);

        buyer1 = (Buyer) new Buyer.Builder().setName("Zisanda").setEmail("zish@gmail.com").setPhoneNumber("0798765897").build();
        buyerService.create(buyer1);

        Set<TransactionHistory> transactionHistories = new HashSet<>();
        TransactionHistory transactionHistory = new TransactionHistory.Builder().setTransaction_id(432).setBook_id(book1).setBuyer(buyer1).setSeller(seller1).setDate(LocalDate.now()).build();
        historyService.create(transactionHistory);

        transactionHistories.add(transactionHistory);

        seller1 = new Seller.Builder().copy(seller1).setInventory(transactionHistories).build();
        buyer1 = new Buyer.Builder().copy(buyer1).setBuyingHistory(transactionHistories).build();

        buyerService.update(buyer1);
        sellerService.update(seller1);
    }

    @Test
    void testCreateSeller() {
        Seller createdSeller = sellerService.update(seller1);
        assertNotNull(createdSeller);
        System.out.println(createdSeller);
    }

}


