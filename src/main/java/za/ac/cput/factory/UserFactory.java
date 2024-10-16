package za.ac.cput.factory
        ;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {

    public static User createUser(Integer userId, String firstName, String lastName, String email, String phoneNumber, String password) {
        if (userId == null || userId <= 0 || Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email)
                || Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(password) ) {
            return null;
        }

        return new User.UserBuilder()
                .setUserId(userId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setPassword(password)
                .build();
    }

}
