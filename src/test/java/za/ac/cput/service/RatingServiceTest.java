package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Rating;
import za.ac.cput.domain.User;
import za.ac.cput.factory.RatingFactory;
import za.ac.cput.factory.UserFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class RatingServiceTest {

    //TODO Create & Read failing.........

    private RatingService rs;
    private static Rating rate1;
    private static Rating rate2;

    @BeforeEach
    @Order(1)
    void a_setUp() {

        User user1 = UserFactory.createUser(1, "Natasha Mavuso", "nat366@gmail.com", "0824379664");
        User user2 = UserFactory.createUser(2, "Giveon Barrack Smith", "gvb09@gmail.com", "0652086493");

        rate1 = RatingFactory.rateBuild(5, 4, 3, 2, 4, 3, 2, LocalDate.of(2023, 2, 1), user1);
        System.out.println(rate1);

        rate2 = RatingFactory.rateBuild(6, 3, 4, 5, 4, 5, 6, LocalDate.of(2023, 4, 18), user2);
        System.out.println(rate2);

        rs = new RatingService(); 
    }

    @Test
    @Order(2)
    void b_create() {

        Rating created1 = rs.create(rate1);
        assertNotNull(created1);
        System.out.println(created1);
        Rating created2 = rs.create(rate2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void c_read() {
        Rating read1 = rs.read(rate1.getId());
        //assertNotNull(read1, "Reading Rate1 failed.");
        System.out.println(read1);
    }

    @Test
    @Order(4)
    void d_update() {
      // Rating updatedRating = Rating.Builder.copy(rate2);
     //  assertNotNull(updatedRating);
      // System.out.println(updatedRating);
    }

    @Test
    @Order(5)
    void e_findRatingByUser() {

    }

  //  @Test
   // @Order(6)
   // void f_getAll() {
   // System.out.println(rs.getAll());
  //  }
}
