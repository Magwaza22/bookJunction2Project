package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.service.TransactionHistoryService;

@RestController
@RequestMapping("/transactionHistory")
public class TransactionHistoryController {

    private final TransactionHistoryService service;

    @Autowired
    TransactionHistoryController(TransactionHistoryService service){ this.service = service; }

    @PostMapping("/save")
    public TransactionHistory save(@RequestBody TransactionHistory transactionHistory){ return service.create(transactionHistory);}

    @GetMapping("/read")
    public TransactionHistory read(@PathVariable String id) { return service.read(id);}

}
