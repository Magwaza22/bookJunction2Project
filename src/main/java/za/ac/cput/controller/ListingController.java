package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Listing;
import za.ac.cput.service.ListingService;

import java.util.List;

@RestController
@RequestMapping
public class ListingController {
    private final ListingService service;

    @Autowired
    ListingController(ListingService service) { this.service = service; }

    @PostMapping("/save")
    public Listing save(@RequestBody Listing listing){return service.create(listing);}

   @GetMapping(value = "read/{id}")
    public Listing read(@PathVariable String id){return service.read(id);}

    @DeleteMapping("/deletebyid/{id}")
    public void delete(@PathVariable String id){service.delete(id);}

    @GetMapping("/getall")
    public List<Listing> getAll(){return service.getall();}
}
