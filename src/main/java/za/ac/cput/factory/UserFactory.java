package za.ac.cput.factory
        ;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {

    public static User createUser(Integer userId, String name, String email, String phoneNumber) {
        if (userId == null || userId <= 0 || Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber)) {
            return null;
        }

        return new User.UserBuilder()
                .setUserId(userId)
                .setName(name)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .build();
    }

}