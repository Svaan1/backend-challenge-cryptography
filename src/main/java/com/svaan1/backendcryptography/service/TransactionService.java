package com.svaan1.backendcryptography.service;

import com.svaan1.backendcryptography.dto.TransactionResponseDTO;
import com.svaan1.backendcryptography.model.Transaction;
import com.svaan1.backendcryptography.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<TransactionResponseDTO> listTransactions() {
        return transactionRepository.findAll().stream().map(Transaction::toResponse).toList();
    }
}
