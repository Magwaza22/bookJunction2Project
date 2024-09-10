package za.ac.cput.factory;


import za.ac.cput.domain.Rating;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.time.LocalDate;


public class RatingFactory {

    public static Rating rateBuild(Long id, int overAllRating, int bookConditionRating, int sellerReliabilityRating, int valueRating, int deliveryRating, int accuracyOfRating, LocalDate date, User user){
        if (Helper.isNullOrEmpty(String.valueOf(id))
                ||Helper.assertInRange(overAllRating) ||
                Helper.assertInRange(bookConditionRating) ||
                Helper.assertInRange(sellerReliabilityRating) ||
                Helper.assertInRange(valueRating) ||
                Helper.assertInRange(deliveryRating) ||
                Helper.assertInRange(accuracyOfRating)||
                Helper.isNullOrEmpty(String.valueOf(date))||
                Helper.isNullOrEmpty(String.valueOf(user)))
            return null;

        return new Rating.Builder()
                .setId(id)
                .setBookConditionRating(bookConditionRating)
                .setSellerReliabilityRating(sellerReliabilityRating)
                .setValueRating(valueRating)
                .setDeliveryRating(deliveryRating)
                .setAccuracyOfRating(accuracyOfRating)
                .setOverAllRating(overAllRating)
                .setDate(date)
                .setUser(user)
                .build();

    }
}
