package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.Objects;

public class TransactionHistory {
    private int transaction_id;
    private int book_id;
    private int user_id_seller;
    private int user_id_buyer;
    private double price;
    private LocalDate date;

    public TransactionHistory(){

    }
    private TransactionHistory(Builder builder){
        this.transaction_id = builder.transaction_id;
        this.book_id = builder.book_id;
        this.user_id_seller = builder.user_id_seller;
        this.user_id_buyer = builder.user_id_buyer;
        this.price = builder.price;
        this.date = builder.date;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public int getUser_id_seller() {
        return user_id_seller;
    }

    public int getUser_id_buyer() {
        return user_id_buyer;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionHistory that)) return false;
        return getTransaction_id() == that.getTransaction_id() && getBook_id() == that.getBook_id() && getUser_id_seller() == that.getUser_id_seller() && getUser_id_buyer() == that.getUser_id_buyer() && Double.compare(getPrice(), that.getPrice()) == 0 && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransaction_id(), getBook_id(), getUser_id_seller(), getUser_id_buyer(), getPrice(), getDate());
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "transaction_id=" + transaction_id +
                ", book_id=" + book_id +
                ", user_id_seller=" + user_id_seller +
                ", user_id_buyer=" + user_id_buyer +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
    public static class Builder {
        private int transaction_id;
        private int book_id;
        private int user_id_seller;
        private int user_id_buyer;
        private double price;
        private LocalDate date;

        public Builder setTransaction_id(int transaction_id) {
            this.transaction_id = transaction_id;
            return this;
        }

        public Builder setBook_id(int book_id) {
            this.book_id = book_id;
            return this;
        }

        public Builder  setUser_id_seller(int user_id_seller) {
            this.user_id_seller = user_id_seller;
            return this;
        }

        public Builder  setUser_id_buyer(int user_id_buyer) {
            this.user_id_buyer = user_id_buyer;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder  setDate(LocalDate date) {
            this.date = date;
            return this;
        }
        public Builder copy(TransactionHistory t){
            this.transaction_id = t.transaction_id;
            this.book_id = t.book_id;
            this.user_id_seller = t.user_id_seller;
            this.user_id_buyer = t.user_id_buyer;
            this.price = t.price;
            this.date = t.date;
            return this;
        }
        public TransactionHistory build(){return new TransactionHistory(this);}
    }
}
