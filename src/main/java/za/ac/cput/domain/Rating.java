package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Rating {
    @Id
    private String id;
    private int overAllRating;
    private int bookConditionRating;
    private int sellerReliabilityRating;
    private int valueRating;
    private int deliveryRating;
    private int accuracyOfRating;
    private LocalDate date;
    private User user;

    public Rating(){}

    private Rating(Builder builder){

        id = builder.id;
        overAllRating = builder.overAllRating;
        bookConditionRating = builder.bookConditionRating;
        sellerReliabilityRating = builder.sellerReliabilityRating;
        valueRating = builder.valueRating;
        deliveryRating = builder.deliveryRating;
        accuracyOfRating = builder.accuracyOfRating;
        date = this.date;

    }

    public String getId() {return id;}

    public int getOverAllRating() {
        return overAllRating;
    }

    public int getBookConditionRating() {
        return bookConditionRating;
    }

    public int getSellerReliabilityRating() {
        return sellerReliabilityRating;
    }

    public int getValueRating() {
        return valueRating;
    }

    public int getDeliveryRating() {
        return deliveryRating;
    }

    public int getAccuracyOfRating() {
        return accuracyOfRating;
    }

    public LocalDate getDate() {return date;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return overAllRating == rating.overAllRating && bookConditionRating == rating.bookConditionRating && sellerReliabilityRating == rating.sellerReliabilityRating && valueRating == rating.valueRating && deliveryRating == rating.deliveryRating && accuracyOfRating == rating.accuracyOfRating && Objects.equals(id, rating.id) && Objects.equals(date, rating.date) && Objects.equals(user, rating.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, overAllRating, bookConditionRating, sellerReliabilityRating, valueRating, deliveryRating, accuracyOfRating, date, user);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", overAllRating=" + overAllRating +
                ", bookConditionRating=" + bookConditionRating +
                ", sellerReliabilityRating=" + sellerReliabilityRating +
                ", valueRating=" + valueRating +
                ", deliveryRating=" + deliveryRating +
                ", accuracyOfRating=" + accuracyOfRating +
                ", date=" + date +
                ", user=" + user +
                '}';
    }

    public static class Builder{
        private String id;
        private int overAllRating;
        private int bookConditionRating;
        private int sellerReliabilityRating;
        private int valueRating;
        private int deliveryRating;
        private int accuracyOfRating;
        private LocalDate date;
        private User user;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setOverAllRating(int overAllRating) {
            this.overAllRating = overAllRating;
            return this;
        }

        public Builder setBookConditionRating(int bookConditionRating) {
            this.bookConditionRating = bookConditionRating;
            return this;
        }

        public Builder setSellerReliabilityRating(int sellerReliabilityRating) {
            this.sellerReliabilityRating = sellerReliabilityRating;
            return this;
        }

        public Builder setValueRating(int valueRating) {
            this.valueRating = valueRating;
            return this;
        }

        public Builder setDeliveryRating(int deliveryRating) {
            this.deliveryRating = deliveryRating;
            return this;
        }

        public Builder setAccuracyOfRating(int accuracyOfRating) {
            this.accuracyOfRating = accuracyOfRating;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Rating.Builder copy(Rating r) {
            this.id = r.id;
            this.overAllRating = r.overAllRating;
            this.bookConditionRating = r.bookConditionRating;
            this.valueRating = r.valueRating;
            this.deliveryRating = r.deliveryRating;
            this.accuracyOfRating = r.accuracyOfRating;
            this.sellerReliabilityRating = r.sellerReliabilityRating;
            this.date = r.date;
            this.user = r.user;
            return this;
        }

        public Rating build(){
            return new Rating(this);
        }
    }
}

