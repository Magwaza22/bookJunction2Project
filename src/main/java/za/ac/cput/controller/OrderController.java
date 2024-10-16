package za.ac.cput.controller;

import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import za.ac.cput.domain.Order;
import za.ac.cput.service.OrderService;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/customer_order")
public class OrderController {
    private final OrderService service;

    @Autowired
    OrderController(OrderService service) { this.service = service; }

    @PostMapping("/saves")
    public Order save(@RequestBody Order order) {
        System.out.println("Order data from controller: " + order);
        return service.create(order);
    }

    @GetMapping("/read/{orderID}")
    public Order read(@PathVariable String orderID) {
        return service.read(Integer.valueOf(orderID));
    }


}
