package za.ac.cput.factory;

import za.ac.cput.domain.BuyerRating;
import za.ac.cput.util.Helper;

public class BuyerRatingFactory {

    public static BuyerRating rateBuild(int overAllRating, int bookConditionRating, int sellerReliabilityRating, int valueRating, int deliveryRating, int accuracyOfRating){
        if (Helper.assertInRange(overAllRating) ||
                Helper.assertInRange(bookConditionRating) ||
                Helper.assertInRange(sellerReliabilityRating) ||
                Helper.assertInRange(valueRating) ||
                Helper.assertInRange(deliveryRating) ||
                Helper.assertInRange(accuracyOfRating))
            return null;

        return new BuyerRating.Builder()
                .setBookConditionRating(bookConditionRating)
                .setSellerReliabilityRating(sellerReliabilityRating)
                .setValueRating(valueRating)
                .setDeliveryRating(deliveryRating)
                .setAccuracyOfRating(accuracyOfRating)
                .setOverAllRating(overAllRating)
                .build();

    }
}
