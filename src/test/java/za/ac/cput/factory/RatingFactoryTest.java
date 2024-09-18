package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Rating;
import za.ac.cput.domain.User;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RatingFactoryTest {

    private String id;
    private int overAllRating;
    private int bookConditionRating;
    private int sellerReliabilityRating;
    private int valueRating;
    private int deliveryRating;
    private int accuracyOfRating;
    private Date date;
    private User user;

    private Rating rate1;
    private Rating rate2;

    User user1 = UserFactory.createUser(1, "Johny Simon Barena", "jbarena@gm.com", "0620699143");
    User user2 = UserFactory.createUser(2, "Mandla Moringa", "moringa@mail.com", "0725369427");

    @BeforeEach
    void setUp() {
        rate1 = RatingFactory.rateBuild("", 4,5,4,3,3,4, LocalDate.of(2023, 2, 1), user1);
        rate2 = RatingFactory.rateBuild("D03", 5, 4, 3, 6, 6, 7, LocalDate.of(2024, 5, 18), user2);
    }

    @Test
    void rateBuild() {
        System.out.println(rate1);
        assertNotNull(rate1);

    }
}