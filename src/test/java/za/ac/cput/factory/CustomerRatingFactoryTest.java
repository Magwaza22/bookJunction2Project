package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.CustomerRating;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRatingFactoryTest {
    private int overAllRating;
    private int bookConditionRating;
    private int sellerReliabilityRating;
    private int valueRating;
    private int deliveryRating;
    private int accuracyOfRating;

    private CustomerRating user1;
    private CustomerRating user2;

    @BeforeEach
    void setup(){
        user1= RatingFactory.rateBuild(4,3,4,3,2,5);
        user2= RatingFactory.rateBuild(3,5,6,8,3,4);
    }

    @Test
    void rateBuild() {

        System.out.println(user1);
        assertEquals(5,4);
    }
}