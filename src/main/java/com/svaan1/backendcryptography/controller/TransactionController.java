package com.svaan1.backendcryptography.controller;

import com.svaan1.backendcryptography.dto.TransactionDTO;
import com.svaan1.backendcryptography.dto.TransactionResponseDTO;
import com.svaan1.backendcryptography.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public List<TransactionResponseDTO> listTransactions() {
        return transactionService.listTransactions();
    }

    @GetMapping(value = "/{transactionId}")
    public TransactionResponseDTO getTransaction(@PathVariable Long transactionId) {
        return transactionService.getTransaction(transactionId);
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
