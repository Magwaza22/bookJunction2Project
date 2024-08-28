package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Author;
import za.ac.cput.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService implements IAuthorService{
    private final AuthorRepository authorRepository;

    @Autowired
    AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author read(String s) {
        return authorRepository.findById(s).orElse(null);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getall() {
        return authorRepository.findAll();
    }
}
