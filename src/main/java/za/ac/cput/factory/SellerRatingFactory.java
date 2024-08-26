package za.ac.cput.factory;
import za.ac.cput.domain.SellerRating;
import za.ac.cput.util.Helper;

public class SellerRatingFactory {
    public static SellerRating builderB(int overAllRatingB, int communicationInteraction, int accuracyOfRatingB){
        if(Helper.assertInRange(overAllRatingB)||
        Helper.assertInRange(communicationInteraction)||
        Helper.assertInRange(accuracyOfRatingB))
            return null;

        return new SellerRating.Builder()
                .setAccuracyOfRatingB(accuracyOfRatingB)
                .setCommunicationInteraction(communicationInteraction)
                .setAccuracyOfRatingB(overAllRatingB)
                .build();
    }
}
