import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
@Entity
public class TransactionHistory {
    @Id
    private Book book;
    private int transaction_id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book_id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
    private LocalDate date;

    public TransactionHistory(){

    }
    private TransactionHistory(Builder builder){
        this.transaction_id = builder.transaction_id;
        this.book_id = builder.book_id;
        this.buyer = builder.buyer;
        this.seller = builder.seller;
        this.date = builder.date;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public Book getBook_id() {
        return book_id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionHistory that = (TransactionHistory) o;
        return transaction_id == that.transaction_id && Objects.equals(book, that.book) && Objects.equals(book_id, that.book_id) && Objects.equals(buyer, that.buyer) && Objects.equals(seller, that.seller) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, transaction_id, book_id, buyer, seller, date);
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "book=" + book +
                ", transaction_id=" + transaction_id +
                ", book_id=" + book_id +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", date=" + date +
                '}';
    }

    public static class Builder {
        private int transaction_id;
        private Book book_id;
        private Buyer buyer;
        private Seller seller;
        private LocalDate date;

        public Builder setTransaction_id(int transaction_id) {
            this.transaction_id = transaction_id;
            return this;
        }

        public Builder setBook_id(Book book_id) {
            this.book_id = book_id;
            return this;
        }

        public Builder setBuyer(Buyer buyer) {
            this.buyer = buyer;
            return this;
        }

        public Builder setSeller(Seller seller) {
            this.seller = seller;
            return this;
        }

        public Builder  setDate(LocalDate date) {
            this.date = date;
            return this;
        }
        public Builder copy(TransactionHistory t){
            this.transaction_id = t.transaction_id;
            this.book_id = t.book_id;
            this.buyer = t.buyer;
            this.seller = t.seller;
            this.date = t.date;
            return this;
        }
        public TransactionHistory build(){return new TransactionHistory(this);}
    }
}
