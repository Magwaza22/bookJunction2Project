package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Author;

import static org.junit.jupiter.api.Assertions.*;

public class AuthorFactoryTest {

    @Test
    public void testCreateAuthor_Successful() {
        Author author = AuthorFactory.createAuthor("J.K.", "Rowling");
        assertNotNull(author);
        assertEquals("J.K.", author.getFirstName());
        assertEquals("Rowling", author.getLastName());

    }

}
