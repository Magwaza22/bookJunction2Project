package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Listing {
    private int listingID;
    private Long bookID;
    private String userID;
    private LocalDate dateListed;
    private double price;
    private String status;
    private String condition;
    public Listing(){
    }
    private Listing(Builder builder){
        this.listingID = builder.listingID;
        this.bookID = builder.bookID;
        this.userID = builder.userID;
        this.dateListed = builder.dateListed;
        this.price = builder.price;
        this.status = builder.status;
        this.condition = builder.condition;
    }

    public int getListingID() {
        return listingID;
    }

    public Long getBookID() {
        return bookID;
    }

    public String getUserID() {
        return userID;
    }

    public LocalDate getDateListed() {
        return dateListed;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Listing listing)) return false;
        return Double.compare(getPrice(), listing.getPrice()) == 0 && Objects.equals(getListingID(), listing.getListingID()) && Objects.equals(getBookID(), listing.getBookID()) && Objects.equals(getUserID(), listing.getUserID()) && Objects.equals(getDateListed(), listing.getDateListed()) && Objects.equals(getStatus(), listing.getStatus()) && Objects.equals(getCondition(), listing.getCondition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListingID(), getBookID(), getUserID(), getDateListed(), getPrice(), getStatus(), getCondition());
    }

    @Override
    public String toString() {
        return "Listing{" +
                "listingID='" + listingID + '\'' +
                ", bookID=" + bookID +
                ", userID='" + userID + '\'' +
                ", dateListed=" + dateListed +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
    public static class Builder {
        private int listingID;
        private Long bookID;
        private String userID;
        private LocalDate dateListed;
        private double price;
        private String status;
        private String condition;

        public Builder setListingID(int listingID) {
            this.listingID = listingID;
            return this;
        }

        public Builder setBookID(Long bookID) {
            this.bookID = bookID;
            return this;
        }

        public Builder setUserID(String userID) {
            this.userID = userID;
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
            this.bookID = l.bookID;
            this.userID = l.userID;
            this.dateListed = l.dateListed;
            this.status = l.status;
            this.condition = condition;
            return this ;
        }
        public Listing build() {
            return new Listing(this);
        }
    }
}

