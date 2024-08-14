package za.ac.cput.factory;

import za.ac.cput.domain.Rating;
import za.ac.cput.util.Helper;

public class RatingFactory {

    public static Rating rateBuild(int overAllRating, int bookConditionRating, int sellerReliabilityRating, int valueRating, int deliveryRating, int accuracyOfRating){
        if (Helper.assertInRange(overAllRating) ||
                Helper.assertInRange(bookConditionRating) ||
                Helper.assertInRange(sellerReliabilityRating) ||
                Helper.assertInRange(valueRating) ||
                Helper.assertInRange(deliveryRating) ||
                Helper.assertInRange(accuracyOfRating))
            return null;

        return new Rating.Builder()
                .setBookConditionRating(bookConditionRating)
                .setSellerReliabilityRating(sellerReliabilityRating)
                .setValueRating(valueRating)
                .setDeliveryRating(deliveryRating)
                .setAccuracyOfRating(accuracyOfRating)
                .setOverAllRating(overAllRating)
                .build();

    }
}
