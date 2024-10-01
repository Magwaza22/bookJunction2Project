package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.Seller;
import za.ac.cput.domain.User;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.service.ISellerService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class SellerControllerTest {
    @Test
    public void testCreateOrderSuccess() {
        User user = new User.UserBuilder().setUserId(Integer.valueOf("12345")).build();
        LocalDate orderDate = LocalDate.now();
        Order order = OrderFactory.createOrder(1, user, orderDate, 100.0, "Pending");

        assertNotNull(order);
        assertEquals(1, order.getOrderID());
        assertEquals(user, order.getUserID());
        assertEquals(orderDate, order.getOrderDate());
        assertEquals(100.0, order.getTotalAmount());
        assertEquals("Pending", order.getOrderStatus());
    }

    @Test
    public void testCreateOrderNullOrderStatus() {
        User user = new User.UserBuilder().setUserId(Integer.valueOf("12345")).build();
        LocalDate orderDate = LocalDate.now();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OrderFactory.createOrder(1, user, orderDate, 100.0, null);
        });

        String expectedMessage = "Order status cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}