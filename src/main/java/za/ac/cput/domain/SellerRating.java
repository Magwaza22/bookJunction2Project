package za.ac.cput.domain;

import java.util.Objects;

public class SellerRating {

    private int overAllRatingB;
    private int communicationInteraction;
    private int accuracyOfRatingB;
    private Seller s;

    public SellerRating(){}

    private SellerRating(Builder builderB){
        overAllRatingB = builderB.overAllRatingB;
        communicationInteraction= builderB.communicationInteraction;
        accuracyOfRatingB = builderB.accuracyOfRatingB;

    }

    public int getOverAllRatingB() {
        return overAllRatingB;
    }

    public int getCommunicationInteraction() {
        return communicationInteraction;
    }

    public int getAccuracyOfRating() {
        return accuracyOfRatingB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerRating that = (SellerRating) o;
        return overAllRatingB == that.overAllRatingB && communicationInteraction == that.communicationInteraction && accuracyOfRatingB == that.accuracyOfRatingB && Objects.equals(s, that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(overAllRatingB, communicationInteraction, accuracyOfRatingB, s);
    }

    @Override
    public String toString() {
        return "SellerRating{" +
                "overAllRatingB=" + overAllRatingB +
                ", communicationInteraction=" + communicationInteraction +
                ", accuracyOfRatingB=" + accuracyOfRatingB +
                ", s=" + s +
                '}';
    }

    public static class Builder{
        private int overAllRatingB;
        private int communicationInteraction;
        private int accuracyOfRatingB;

        public Builder setOverAllRatingB(int overAllRatingB) {
            this.overAllRatingB = overAllRatingB;
            return this;
        }

        public Builder setCommunicationInteraction(int communicationInteraction) {
            this.communicationInteraction = communicationInteraction;
            return this;
        }

        public Builder setAccuracyOfRatingB(int accuracyOfRatingB) {
            this.accuracyOfRatingB = accuracyOfRatingB;
            return this;
        }
    }

}
