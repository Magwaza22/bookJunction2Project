package za.ac.cput.factory;

import za.ac.cput.domain.Author;
import za.ac.cput.domain.Book;
import za.ac.cput.util.Helper;

import java.util.Arrays;

public class BookFactory {
    public static Book createBook(Long bookID, byte[] bookPhoto, String ISBN, String title, String edition,String authorFirstName, String authorLastName, String authorEmail, String authorPhoneNumber, String authorNationality, Double price) {
        if (Helper.isNullOrEmpty(String.valueOf(bookID)) || Helper.isNullOrEmpty(Arrays.toString(bookPhoto))
                || Helper.isNullOrEmpty(ISBN) || Helper.isNullOrEmpty(title) || Helper.isNullOrEmpty(edition)
                || Helper.isNullOrEmpty(authorFirstName) || Helper.isNullOrEmpty(authorLastName)
                || Helper.isNullOrEmpty(authorEmail) || Helper.isNullOrEmpty(authorPhoneNumber)
                || Helper.isNullOrEmpty(authorNationality) || Helper.isNullOrEmpty(String.valueOf(price))) {
            return null;
        }

        Author author = AuthorFactory.createAuthor(authorFirstName, authorLastName,authorEmail, authorPhoneNumber, authorNationality);
        if (author == null) {
            return null;
        }

        return new Book.Builder().setBookID(bookID)
                .setBookPhoto(bookPhoto)
                .setISBN(ISBN)
                .setTitle(title)
                .setEdition(edition)
                .setAuthor(author)
                .setPrice(price)
                .build();
    }

    public static Book buildBook(Long bookID, byte[] bookPhoto, String ISBN, String title, String edition, Author author,Double price) {
        throw new UnsupportedOperationException();
    }
}
