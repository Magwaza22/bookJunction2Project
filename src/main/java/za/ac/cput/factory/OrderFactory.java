package za.ac.cput.factory;




import za.ac.cput.domain.Order;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.time.LocalDate;


public class OrderFactory {


    public static Order createOrder(Integer orderID, User userId, LocalDate orderDate, Double totalAmount, String orderStatus) {
        if (Helper.isNullOrEmpty(String.valueOf(orderID))) {
            throw new IllegalArgumentException("Order ID cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(String.valueOf(userId))) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (Helper.isNullOrEmpty(String.valueOf(orderDate))) {
            throw new IllegalArgumentException("Order date cannot be null");
        }
        if (Helper.isNullOrEmpty(String.valueOf(totalAmount))) {
            throw new IllegalArgumentException("Total amount cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(orderStatus)) {
            throw new IllegalArgumentException("Order status cannot be null or empty");
        }


        return new Order.Builder()
                .setOrderID(orderID)
                .setBuyerId(userId)
                .setOrderDate(orderDate)
                .setTotalAmount(totalAmount)
                .setOrderStatus(orderStatus)
                .build();
    }
    public static Order buildOrder(Integer orderID, User userId, LocalDate orderDate, Double totalAmount, String orderStatus) {
        throw new UnsupportedOperationException();
    }
}



