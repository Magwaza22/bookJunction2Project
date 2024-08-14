package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Rating {
    @Id
    private int overAllRating;
    private int bookConditionRating;
    private int sellerReliabilityRating;
    private int valueRating;
    private int deliveryRating;
    private int accuracyOfRating;

    public Rating(){}

    private Rating(Builder builder){
        overAllRating = builder.overAllRating;
        bookConditionRating = builder.bookConditionRating;
        sellerReliabilityRating = builder.sellerReliabilityRating;
        valueRating = builder.valueRating;
        deliveryRating = builder.deliveryRating;
        accuracyOfRating = builder.accuracyOfRating;

    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return overAllRating == rating.overAllRating && bookConditionRating == rating.bookConditionRating && sellerReliabilityRating == rating.sellerReliabilityRating && valueRating == rating.valueRating && deliveryRating == rating.deliveryRating && accuracyOfRating == rating.accuracyOfRating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(overAllRating, bookConditionRating, sellerReliabilityRating, valueRating, deliveryRating, accuracyOfRating);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "overAllRating=" + overAllRating +
                ", bookConditionRating=" + bookConditionRating +
                ", sellerReliabilityRating=" + sellerReliabilityRating +
                ", valueRating=" + valueRating +
                ", deliveryRating=" + deliveryRating +
                ", accuracyOfRating=" + accuracyOfRating +
                '}';
    }
    public static class Builder{
        private int overAllRating;
        private int bookConditionRating;
        private int sellerReliabilityRating;
        private int valueRating;
        private int deliveryRating;
        private int accuracyOfRating;

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

        public Rating build(){
            return new Rating(this);
        }
    }
}

