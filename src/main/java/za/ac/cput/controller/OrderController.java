package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import za.ac.cput.domain.Order;
import za.ac.cput.service.OrderService;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:5173")

@RequestMapping("/Order")
public class OrderController {
    private final OrderService service;

    @Autowired
    OrderController(OrderService service) { this.service = service; }

    @PostMapping("/save")
    public Order save(@RequestBody Order order) {
        return service.create(order);
    }

    @GetMapping("/read/{orederID}")
    public Order read(@PathVariable String orderID) {
        return service.read(Integer.valueOf(orderID));
    }




}
