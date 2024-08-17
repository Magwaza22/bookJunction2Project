package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Book;
import za.ac.cput.repository.BookRepository;

import java.util.List;

@Service
public class BookService implements IBookService{
    private BookRepository bookRepository;

    @Autowired
    BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book read(Long aLong) {
        return bookRepository.findBookByISBN(String.valueOf(aLong));
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long booKID) {
        bookRepository.delete(booKID);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

}
