package za.ac.cput.factory;

import za.ac.cput.domain.Author;
import za.ac.cput.util.Helper;

import java.util.Arrays;

public class AuthorFactory {

    public static Author createAuthor(String firstName, String lastName) {
                if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName))
                    return null;

                return new Author.Builder().setFirstName(firstName)
                        .setLastName(lastName)
                        .build();
    }
}



