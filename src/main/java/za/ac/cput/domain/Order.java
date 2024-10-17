package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "customer_order")
public class Order {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    private LocalDate orderDate;

    private double totalAmount;
    private String orderStatus;

    public Order() {

    }
    private Order (Builder builder){
        this.orderID = builder.orderID;
        this.userId = builder.userId;
        this.orderDate = builder.orderDate;
        this.totalAmount = builder.totalAmount;
        this.orderStatus = builder.orderStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public User getUserID() {
        return userId;
    }

    public LocalDate getOrderDate() {
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
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && Double.compare(totalAmount, order.totalAmount) == 0 && Objects.equals(userId, order.userId) && Objects.equals(orderDate, order.orderDate) && Objects.equals(orderStatus, order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, userId, orderDate, totalAmount, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", userId=" + userId +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }

    public static class Builder {
        private int orderID;
        private User userId;
        private LocalDate orderDate;
        private double totalAmount;
        private String orderStatus;


        public Builder setOrderID(int orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setBuyerId(User userId) {
            this.userId = userId;
            return this;
        }

        public Builder setOrderDate(LocalDate orderDate) {
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

        public Builder setUserId(User userId) {
            this.userId = userId;
            return this;
        }

        public Builder copy(Order o) {
            this.orderID = o.orderID;
            this.userId = o.userId;
            this.orderDate = o.orderDate;
            this.totalAmount = o.totalAmount;
            this.orderStatus = o.orderStatus;
            return this ;
        }



        public Order build(){return new Order(this);}
    }
}
