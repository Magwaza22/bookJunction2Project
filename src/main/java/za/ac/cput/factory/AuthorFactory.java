package za.ac.cput.factory;

import za.ac.cput.domain.Author;
import za.ac.cput.util.Helper;

import java.util.Arrays;

public class AuthorFactory {

    public static Author createAuthor(String firstName, String lastName, String email, String phoneNumber, String nationality) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(String.valueOf(Helper.isValidEmail(email))) || Helper.isNullOrEmpty(phoneNumber)
                || Helper.isNullOrEmpty(nationality))
            return null;

        return new Author.Builder().setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setNationality(nationality)
                .build();
    }
}
