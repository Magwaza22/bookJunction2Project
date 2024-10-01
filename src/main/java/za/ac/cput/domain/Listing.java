package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listingID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user; // Seller

    private LocalDate dateListed;

    private String status;

    public Listing() {
    }

    protected Listing(Builder builder) {
        this.listingID = builder.listingID;
        this.book = builder.book;
        this.user = builder.user;
        this.dateListed = builder.dateListed;
        this.status = builder.status;
    }


    public int getListingID() {
        return listingID;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDateListed() {
        return dateListed;
    }

    public User getUser() {
        return user;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Listing listing)) return false;
        return getListingID() == listing.getListingID() && Objects.equals(getBook(), listing.getBook()) && Objects.equals(getUser(), listing.getUser()) && Objects.equals(getDateListed(), listing.getDateListed()) && Objects.equals(getStatus(), listing.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListingID(), getBook(), getUser(), getDateListed(), getStatus());
    }

    @Override
    public String toString() {
        return "Listing{" +
                "listingID=" + listingID +
                ", book=" + book +
                ", user=" + user +
                ", dateListed=" + dateListed +
                ", status='" + status + '\'' +
                '}';
    }

    // Builder class
    public static class Builder {
        private int listingID;
        private Book book;
        private User user; // Seller
        private LocalDate dateListed;
        private String status;

        public Builder setListingID(int listingID) {
            this.listingID = listingID;
            return this;
        }

        public Builder setBook(Book book) {
            this.book = book;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setDateListed(LocalDate dateListed) {
            this.dateListed = dateListed;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }


        public Builder copy(Listing l) {
            this.listingID = l.listingID;
            this.book = l.book;
            this.user = l.user;
            this.dateListed = l.dateListed;
            this.status = l.status;
            return this;
        }

        // Build method
        public Listing build() {
            return new Listing(this);
        }
    }
}

