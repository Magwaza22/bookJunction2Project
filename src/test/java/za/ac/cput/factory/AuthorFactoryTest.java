package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Author;

import static org.junit.jupiter.api.Assertions.*;

public class AuthorFactoryTest {

    @Test
    public void testCreateAuthor_Successful() {
        Author author = AuthorFactory.createAuthor("J.K.", "Rowling","rowling@pub.org",  "0748274967", "American");
        assertNotNull(author);
        assertEquals("J.K.", author.getFirstName());
        assertEquals("Rowling", author.getLastName());
        assertEquals("rowling@pub.org", author.getEmail());
        assertEquals("0748274967", author.getPhoneNumber());
        assertEquals("American", author.getNationality());
    }

}
