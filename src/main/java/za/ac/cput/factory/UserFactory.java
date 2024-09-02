package za.ac.cput.factory
        ;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {

    public static User createUser(String userId, String name, String email, String phoneNumber) {
        if (Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(name) ||
                Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber)) {
            return null; // or throw an IllegalArgumentException
        }

        return new User.UserBuilder()
                .setUserId(userId)
                .setName(name)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .build();
    }

    public static User buildUser(String userId, String name, String email, String phoneNumber) {
        throw new UnsupportedOperationException();
    }
}