package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;

import java.util.Date;

public class OrderFactory {
    public static Order createOrder(int orderID, int userID, int listingID, Date orderDate, double totalAmount, String orderStatus) {
        if (Helper.isNullOrEmpty(String.valueOf(orderID)) || Helper.isNullOrEmpty(String.valueOf(userID))
                || Helper.isNullOrEmpty(String.valueOf(listingID)) || Helper.isNullOrEmpty(String.valueOf(orderDate)) || Helper.isNullOrEmpty(String.valueOf(totalAmount))
                || Helper.isNullOrEmpty(String.valueOf(orderStatus)))
            return null;

        return new Order.Builder().setOrderID (orderID)
                .setUserID(userID)
                .setListingID(listingID)
                .setOrderDate(orderDate)
                .setTotalAmount(totalAmount)
                .setOrderStatus( orderStatus)
                .build();
    }
}
