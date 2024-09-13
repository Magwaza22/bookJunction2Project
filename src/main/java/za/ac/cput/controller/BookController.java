package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Book;
import za.ac.cput.service.BookService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService service;

    @Autowired
    BookController(BookService service) { this.service = service; }

    @PostMapping("/save")
    public Book save(@RequestBody Book book) {
        return service.create(book);
    }

    @GetMapping("/read/{id}")
    public Book read(@PathVariable String id) {
        return service.read(Integer.valueOf(id));
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteByID(@PathVariable String id){service.delete(Integer.valueOf(id));}

    @GetMapping("/getall")
    public List<Book> getAll(){return service.getall();}
}
