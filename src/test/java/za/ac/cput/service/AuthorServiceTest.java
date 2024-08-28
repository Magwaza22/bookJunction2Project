package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Author;
import za.ac.cput.factory.AuthorFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AuthorServiceTest {
    private AuthorService authorService;
    private static Author author;
    @BeforeEach
    void setUp() {
        author = AuthorFactory.createAuthor("J.K.", "Rowling","rowling@pub.org",  "0748274967", "American");
        assertNotNull(author);
        System.out.println(author);
    }

    @Test
    void create() {
        Author created1 = authorService.create(author);
        assertNotNull(created1);
        System.out.println(created1);
    }

    @Test
    void read() {
        assert author!= null;
        Author read = authorService.read(author.getEmail());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        Author newAuthor = new Author.Builder().copy(author).setEmail("JK.rowling@yahoo.ac.za")
                .build();
        Author updated =authorService.update(newAuthor);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void getall() {
        System.out.println(authorService.getall());
    }
}