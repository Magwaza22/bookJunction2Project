package za.ac.cput.domain;

import java.util.Date;
import java.util.Objects;

public class Order {
    private int orderID;
    private int userID;
    private int listingID;
    private Date orderDate;
    private double totalAmount;
    private String orderStatus;

    public Order() {

    }
    private Order (Builder builder){
        this.orderID = builder.orderID;
        this.userID = builder.userID;
        this.listingID = builder.listingID;
        this.orderDate = builder.orderDate;
        this.totalAmount = builder.totalAmount;
        this.orderStatus = builder.orderStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public int getListingID() {
        return listingID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getOrderID() == order.getOrderID() && getUserID() == order.getUserID() && getListingID() == order.getListingID() && Double.compare(getTotalAmount(), order.getTotalAmount()) == 0 && Objects.equals(getOrderDate(), order.getOrderDate()) && Objects.equals(getOrderStatus(), order.getOrderStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderID(), getUserID(), getListingID(), getOrderDate(), getTotalAmount(), getOrderStatus());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", userID=" + userID +
                ", listingID=" + listingID +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
    public static class Builder {
        private int orderID;
        private int userID;
        private int listingID;
        private Date orderDate;
        private double totalAmount;
        private String orderStatus;


        public Builder setOrderID(int orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setUserID(int userID) {
            this.userID = userID;
            return this;
        }

        public Builder setListingID(int listingID) {
            this.listingID = listingID;
            return this;

        }

        public Builder setOrderDate(Date orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder copy(Order o) {
            this.orderID = o.orderID;
            this.userID = o.userID;
            this.listingID = o.listingID;
            this.orderDate = o.orderDate;
            this.totalAmount = o.totalAmount;
            this.orderStatus = o.orderStatus;
            return this ;
        }



public Order build(){return new Order(this);
}
    }
}
