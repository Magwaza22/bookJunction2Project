package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Author;
import za.ac.cput.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService implements IAuthorService{
    private AuthorRepository authorRepository;

    @Autowired
    AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    @Override
    public Author create(Author author) {
        return null;
    }

    @Override
    public Author read(String s) {
        return null;
    }

    @Override
    public Author update(Author author) {
        return null;
    }

    @Override
    public List<Author> getall() {
        return null;
    }
}
