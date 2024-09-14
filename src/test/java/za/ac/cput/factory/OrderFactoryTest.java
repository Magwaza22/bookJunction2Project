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
        User user = new User.UserBuilder().setUserId(1234).build();
        LocalDate orderDate = LocalDate.now();
        Order order = OrderFactory.createOrder(1, user, orderDate, 100.0, "Pending");

        assertNotNull(order);
        assertEquals(1, order.getOrderID());
        assertEquals(user, order.getUserID());
        assertEquals(orderDate, order.getOrderDate());
        assertEquals(100.0, order.getTotalAmount());
        assertEquals("Pending", order.getOrderStatus());
    }

}






