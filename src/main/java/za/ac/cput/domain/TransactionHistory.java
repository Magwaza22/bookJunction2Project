package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
@Entity
public class TransactionHistory {
    @Id
    private int transactionID;
    @ManyToOne
    @JoinColumn(name = "bookID")
    private Book bookID;

    @ManyToOne
    @JoinColumn(name = "userId")//buyer
    private User user;
    private LocalDate date;

    public TransactionHistory(){ }
    private TransactionHistory(Builder builder){
        this.transactionID = builder.transactionID;
        this.bookID = builder.bookID;
        this.user = builder.user;
        this.date = builder.date;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public Book getBookID() {
        return bookID;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionHistory that)) return false;
        return getTransactionID() == that.getTransactionID() && Objects.equals(getBookID(), that.getBookID()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransactionID(), getBookID(), getUser(), getDate());
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "transactionID=" + transactionID +
                ", bookID=" + bookID +
                ", user=" + user +
                ", date=" + date +
                '}';
    }

    public static class Builder {
        private int transactionID;
        private Book bookID;
        private User user;
        private LocalDate date;

        public Builder setTransactionID(int transactionID) {
            this.transactionID = transactionID;
            return this;
        }

        public Builder setBookID(Book bookID) {
            this.bookID = bookID;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder copy(TransactionHistory t){
            this.transactionID = t.transactionID;
            this.bookID = t.bookID;
            this.user = t.user;
            this.date = t.date;
            return this;
        }
        public TransactionHistory build(){return new TransactionHistory(this);}
    }
}
