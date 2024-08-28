package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.BuyerRating;

import static org.junit.jupiter.api.Assertions.*;

class BuyerRatingFactoryTest {
    private int overAllRating;
    private int bookConditionRating;
    private int sellerReliabilityRating;
    private int valueRating;
    private int deliveryRating;
    private int accuracyOfRating;

    private BuyerRating user1;
    private BuyerRating user2;

    @BeforeEach
    void setup(){
        user1= BuyerRatingFactory.rateBuild(4,3,4,3,2,5);
        user2= BuyerRatingFactory.rateBuild(3,5,6,8,3,4);
    }

    @Test
    void rateBuild() {

        System.out.println(user1);
        assertEquals(5,4);
    }
}