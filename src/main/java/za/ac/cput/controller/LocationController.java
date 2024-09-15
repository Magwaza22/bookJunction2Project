package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Location;
import za.ac.cput.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService service;

    @Autowired
    public LocationController(LocationService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Location save(@RequestBody Location location) {
        return service.create(location);
    }

    @GetMapping("/read/{id}")
    public Location read(@PathVariable int id) {
        return service.read(id);
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteByID(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/getall")
    public List<Location> getAll() {
        return service.getAll();
    }
}
