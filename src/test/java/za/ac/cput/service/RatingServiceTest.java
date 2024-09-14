package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.RatingFactory;
import za.ac.cput.factory.UserFactory;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class RatingServiceTest {

    private final BuyerService buyerService;
    private final SellerService sellerService;
    private final BookService bookService;
    private final TransactionHistoryService historyService;
    private final RatingService rs;

    private Book book1;
    private Author author;
    private Buyer buyer1;
    private Seller seller1;
    private Rating rate1;

    @Autowired
    RatingServiceTest(BuyerService buyerService, SellerService sellerService, BookService bookService, TransactionHistoryService historyService, RatingService rs) {
        this.buyerService = buyerService;
        this.sellerService = sellerService;
        this.bookService = bookService;
        this.historyService = historyService;
        this.rs = rs;
    }

    @BeforeEach
    @Order(1)
    void a_setUp() {

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

        rate1 = RatingFactory.rateBuild(2L, 4, 3, 2, 4, 3, 2, LocalDate.of(2023, 2, 1), buyer1);
        System.out.println(rate1);

    }

    @Test
    @Order(2)
    void b_create() {
        Rating created1 = rs.create(rate1);
        assertNotNull(created1);
        System.out.println(created1);
    }

    @Test
    @Order(3)
    void c_read() {
        Rating read1 = rs.read(rate1.getId());
        //assertNotNull(read1, "Reading Rate1 failed.");
        System.out.println(read1);
    }

    @Test
    @Order(4)
    void d_update() {
      // Rating updatedRating = Rating.Builder.copy(rate2);
     //  assertNotNull(updatedRating);
      // System.out.println(updatedRating);
    }

    @Test
    @Order(5)
    void e_findRatingByUser() {

    }

  //  @Test
   // @Order(6)
   // void f_getAll() {
   // System.out.println(rs.getAll());
  //  }
}
