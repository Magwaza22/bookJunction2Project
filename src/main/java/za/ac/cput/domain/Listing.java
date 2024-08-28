package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.User;

import java.time.LocalDate;
import java.util.Objects;
@Entity
public class Listing {
    @Id
    private int listingID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Seller

    private LocalDate dateListed;
    private double price;
    private String status;
    @Column(name = "item_condition")
    private String condition;
    public Listing(){
    }
    private Listing(Builder builder){
        this.listingID = builder.listingID;
        this.book = builder.bookID;
        this.user = builder.user;
        this.dateListed = builder.dateListed;
        this.price = builder.price;
        this.status = builder.status;
        this.condition = builder.condition;
    }

    public int getListingID() {
        return listingID;
    }

    public LocalDate getDateListed() {
        return dateListed;
    }

    public double getPrice() {
        return price;
    }

    public Book getBook() { return book;}

    public User getUser() {return user;}

    public String getStatus() {
        return status;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Listing listing = (Listing) o;
        return listingID == listing.listingID && Double.compare(price, listing.price) == 0 && Objects.equals(book, listing.book) && Objects.equals(user, listing.user) && Objects.equals(dateListed, listing.dateListed) && Objects.equals(status, listing.status) && Objects.equals(condition, listing.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listingID, book, user, dateListed, price, status, condition);
    }

    @Override
    public String toString() {
        return "Listing{" +
                "listingID=" + listingID +
                ", book=" + book +
                ", user=" + user +
                ", dateListed=" + dateListed +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }

    public static class Builder {
        private int listingID;
        private Book bookID;
        private User user; // Seller

        private LocalDate dateListed;
        private double price;
        private String status;
        private String condition;

        public Builder setListingID(int listingID) {
            this.listingID = listingID;
            return this;
        }

        public Builder setBookID(Book bookID) {
            this.bookID = bookID;
            return this;
        }

        public Builder setUserID(User user) {
            this.user = user;
            return this;
        }

        public Builder setDateListed(LocalDate dateListed) {
            this.dateListed = dateListed;
            return this;
        }

        public  Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setCondition(String condition) {
            this.condition = condition;
            return this;
        }
        public Listing.Builder copy(Listing l) {
            this.listingID = l.listingID;
            this.bookID = l.book;
            this.user = l.user;
            this.dateListed = l.dateListed;
            this.status = l.status;
            this.condition = l.condition;
            return this ;
        }
        public Listing build() {
            return new Listing(this);
        }
    }
}

