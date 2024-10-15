package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.domain.Notification;

import za.ac.cput.service.BookService;
import za.ac.cput.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService service;

    @Autowired
    NotificationController(NotificationService service) { this.service = service; }

    @PostMapping("/save")
    public Notification save(@RequestBody Notification notification) {
        return service.create(notification);
    }

    @GetMapping("/read/{id}")
    public Notification read(@PathVariable String id) {
        return service.read(Integer.valueOf(id));
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteByID(@PathVariable String id){service.delete(Integer.valueOf(id));}

    @GetMapping("/getall")
    public List<Notification> getAll(){return service.getall();}
}
