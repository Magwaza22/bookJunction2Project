package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Book;
import za.ac.cput.repository.BookRepository;

import java.util.List;

@Service
public class BookService implements IBookService{
    private final BookRepository bookRepository;

    @Autowired
    BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book read(Integer bookId) {
        return bookRepository.findById(bookId).orElseThrow(()-> new RuntimeException("Book not exits."));
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(int bookID) {
        bookRepository.deleteById(bookID);
    }

    @Override
    public List<Book> getall() {
        return bookRepository.findAll();
    }
}
