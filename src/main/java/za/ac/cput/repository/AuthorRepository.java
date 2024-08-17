package za.ac.cput.repository;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.Book;

@Repository
public interface AuthorRepository extends BookRepository {
    Book findByAuthor (Author author);
}
