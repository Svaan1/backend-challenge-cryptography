package com.svaan1.backendcryptography.controller;

import com.svaan1.backendcryptography.dto.TransactionDTO;
import com.svaan1.backendcryptography.dto.TransactionResponse;
import com.svaan1.backendcryptography.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<Page<TransactionResponse>> listTransactions(Pageable pageable) {
        Page<TransactionResponse> transactionResponseList = transactionService.listTransactions(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(transactionResponseList);
    }

    @GetMapping(value = "/{transactionId}")
    public ResponseEntity<TransactionResponse> getTransaction(@PathVariable Long transactionId) {
        TransactionResponse transactionResponse = transactionService.getTransaction(transactionId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(transactionResponse);
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody @Validated TransactionDTO transactionDTO) {
        TransactionResponse transactionResponse = transactionService.createTransaction(transactionDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(transactionResponse);
    }

    @PutMapping(value = "/{transactionId}")
    public ResponseEntity<TransactionResponse> updateTransaction(@PathVariable Long transactionId, @RequestBody @Validated TransactionDTO transactionDTO) {
        TransactionResponse transactionResponse = transactionService.updateTransaction(transactionId, transactionDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(transactionResponse);
    }

    @DeleteMapping(value = "/{transactionId}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long transactionId) {
        transactionService.deleteTransaction(transactionId);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
