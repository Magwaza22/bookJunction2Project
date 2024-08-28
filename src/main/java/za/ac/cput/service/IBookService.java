package za.ac.cput.service;

import za.ac.cput.domain.Book;

import java.util.List;

public interface IBookService extends IService<Book, Long>{

    void delete(Long bookID);
    List<Book> getall();

}
