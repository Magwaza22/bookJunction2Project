package za.ac.cput.factory
        ;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {

    public static User createUser(String firstName, String lastName, String email, String phoneNumber, String password) {
        if (Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(email)
                || Helper.isNullOrEmpty(phoneNumber)
                || Helper.isNullOrEmpty(password)) {
            return null;
        }

        return new User(null, firstName, lastName, email, phoneNumber, password);
    }
}
