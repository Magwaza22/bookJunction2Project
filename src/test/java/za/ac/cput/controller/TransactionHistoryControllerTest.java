package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.repository.TransactionHistoryRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionHistoryControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/bookjunction2Project/transactionhistory";

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    private TransactionHistory testTransactionHistory;

    @BeforeEach
    public void setUp() {
        // Clean up the database before each test
        transactionHistoryRepository.deleteAll();

        // Create a test transaction history record
        testTransactionHistory = new TransactionHistory();
        testTransactionHistory.setTransactionID(1);
        testTransactionHistory.setBookID(101);
        testTransactionHistory.setUser(501);
        testTransactionHistory.setDate(LocalDate.now());

        // Save the test record to the database
        transactionHistoryRepository.save(testTransactionHistory);
    }

    @Test
    public void save(){
        // Create a new transaction history object to be saved
        TransactionHistory newTransactionHistory = new TransactionHistory();
        newTransactionHistory.setTransactionID(2);
        newTransactionHistory.setBookID(102);
        newTransactionHistory.setUserID(502);
        newTransactionHistory.setDate(LocalDate.now());

        // Send POST request to save the transaction history
        HttpEntity<TransactionHistory> request = new HttpEntity<>(newTransactionHistory);
        ResponseEntity<TransactionHistory> response = restTemplate.postForEntity("/transactionHistory/save", request, TransactionHistory.class);

        // Validate response status and body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(102, response.getBody().getBookID());
        assertEquals(502, response.getBody().getUser());
    }
    @Test
    public void read(){
        // Send GET request to read the transaction history by ID
        ResponseEntity<TransactionHistory> response = restTemplate.getForEntity("/transactionHistory/read?id={id}", TransactionHistory.class, testTransactionHistory.getId());

        // Validate response status and body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(testTransactionHistory.getTransactionID(), response.getBody().getTransactionID());
        assertEquals(testTransactionHistory.getBookID(), response.getBody().getBookID());
        assertEquals(testTransactionHistory.getUser(), response.getBody().getUser());
    }
    }



