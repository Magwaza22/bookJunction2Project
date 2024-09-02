package za.ac.cput.factory;



import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class OrderFactoryTest {

    @Test
    public void testCreateOrderSuccess() {
        User user = new User.UserBuilder().setUserId("12345").build();
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
    public void testCreateOrderNullOrderID() {
        User user = new User.UserBuilder().setUserId("12345").build();
        LocalDate orderDate = LocalDate.now();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OrderFactory.createOrder(null, user, orderDate, 100.0, "Pending");
        });

        String expectedMessage = "Order ID cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testCreateOrderNullUser() {
        LocalDate orderDate = LocalDate.now();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OrderFactory.createOrder(1, null, orderDate, 100.0, "Pending");
        });

        String expectedMessage = "User ID cannot be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testCreateOrderNullOrderDate() {
        User user = new User.UserBuilder().setUserId("12345").build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OrderFactory.createOrder(1, user, null, 100.0, "Pending");
        });

        String expectedMessage = "Order date cannot be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testCreateOrderNullTotalAmount() {
        User user = new User.UserBuilder().setUserId("12345").build();
        LocalDate orderDate = LocalDate.now();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OrderFactory.createOrder(1, user, orderDate, null, "Pending");
        });

        String expectedMessage = "Total amount cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testCreateOrderNullOrderStatus() {
        User user = new User.UserBuilder().setUserId("12345").build();
        LocalDate orderDate = LocalDate.now();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OrderFactory.createOrder(1, user, orderDate, 100.0, null);
        });

        String expectedMessage = "Order status cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}

