package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Appointment;
import za.ac.cput.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService service;

    @Autowired
    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Appointment save(@RequestBody Appointment appointment) {
        return service.create(appointment);
    }

    @GetMapping("/read/{id}")
    public Appointment read(@PathVariable int id) {
        return service.read(id);
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteByID(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/getall")
    public List<Appointment> getAll() {
        return service.getAll();
    }
}
