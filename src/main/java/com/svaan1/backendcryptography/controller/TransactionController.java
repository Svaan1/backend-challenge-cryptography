package com.svaan1.backendcryptography.controller;

import com.svaan1.backendcryptography.dto.TransactionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @GetMapping
    public void listTransactions() {

    }

    @GetMapping(value = "/{transactionId}")
    public void getTransaction(@PathVariable Long transactionId) {

    }

    @PostMapping
    public void createTransaction(@RequestBody TransactionDTO transactionDTO) {

    }

    @PutMapping(value = "/{transactionId}")
    public void updateTransaction(@PathVariable Long transactionId, @RequestBody TransactionDTO transactionDTO) {

    }

    @DeleteMapping(value = "/{id}")
    public void deleteTransaction(@PathVariable("id") Long transactionId) {

    }

}
