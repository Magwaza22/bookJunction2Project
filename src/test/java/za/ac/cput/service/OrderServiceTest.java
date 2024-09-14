package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.BookFactory;
import za.ac.cput.factory.OrderFactory;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderServiceTest {


    private final OrderService orderService;
    private final SellerService sellerService;
    private final BuyerService buyerService;
    private final BookService bookService;
    private final TransactionHistoryService historyService;


    private za.ac.cput.domain.Order order1;
    private static Buyer buyer1;
    private static Seller seller1;
    private static Book book1;
    private static Author author1;


    @Autowired
    OrderServiceTest(OrderService orderService, SellerService sellerService, BuyerService buyerService, BookService bookService, TransactionHistoryService historyService) {
        this.orderService = orderService;
        this.sellerService = sellerService;
        this.buyerService = buyerService;
        this.bookService = bookService;
        this.historyService = historyService;
    }


    @BeforeEach
    void setUp() {

//        author1 = new Author.Builder().setFirstName("Wisani").setLastName("Magwaza").build();

        byte[] bookPhoto = new byte[]{1, 2, 3};
        author1 = new Author.Builder().setFirstName("Anthony").setLastName("Russo").build();
        book1 = new Book.Builder().setBookPhoto(bookPhoto).setISBN("978-3-16").setTitle("Avengers:Endgame").setEdition("1st Edition").setAuthor(author1).setPrice(1200.00).build();
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

        LocalDate date1 = LocalDate.now();
        order1 = OrderFactory.createOrder(1234, buyer1,date1 , 700.00, "pending");
    }

    @Test
    @Order(1)
    void create() {
        za.ac.cput.domain.Order createdOrder1 = orderService.create(order1);
        assertNotNull(createdOrder1);
        System.out.println(createdOrder1);
    }

    @Test
    @Order(2)
    void read() {
//        za.ac.cput.domain.Order readOrder = orderService.read(order1.getOrderID());
//        System.out.println(readOrder);
    }

    @Test
    @Order(3)
    void update() {
//        za.ac.cput.domain.Order updateOrder = new za.ac.cput.domain.Order.Builder().copy(order1).setTotalAmount(900.00).build();
//        System.out.println(updateOrder);
    }

    @Test
    @Order(4)
    void getAll() {
//        Set<za.ac.cput.domain.Order> allOrder = orderService.getAll();
//        System.out.println(allOrder);
    }
}