package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Author;
import za.ac.cput.service.AuthorService;

import java.util.List;
@RestController
@RequestMapping("/author")
public class AuthorController {
        private final AuthorService service;

        @Autowired
        AuthorController(AuthorService service) { this.service = service; }

        @PostMapping("/save")
        public Author save(@RequestBody Author author) {
            return service.create(author);
        }

        @GetMapping("/read/{id}")
        public Author read(@PathVariable String id) {
            return service.read(id);
        }

        @GetMapping("/getall")
        public List<Author> getAll(){return service.getall();}

    }
