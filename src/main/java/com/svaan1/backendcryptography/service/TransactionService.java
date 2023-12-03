package com.svaan1.backendcryptography.service;

import com.svaan1.backendcryptography.converter.TransactionConverter;
import com.svaan1.backendcryptography.dto.TransactionDTO;
import com.svaan1.backendcryptography.dto.TransactionResponseDTO;
import com.svaan1.backendcryptography.model.Transaction;
import com.svaan1.backendcryptography.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionConverter transactionConverter;

    private final TransactionRepository transactionRepository;

    public List<TransactionResponseDTO> listTransactions() {
        return transactionRepository.findAll().stream().map(transactionConverter::toResponse).toList();
    }

    public TransactionResponseDTO getTransaction(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow();

        return transactionConverter.toResponse(transaction);
    }

    public void createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = transactionConverter.toEntity(transactionDTO);

        transactionRepository.save(transaction);
    }

    public void updateTransaction(Long transactionId, TransactionDTO transactionDTO) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow();

        transaction.setUserDocument(transactionDTO.getUserDocument());
        transaction.setCreditCardToken(transactionDTO.getCreditCardToken());
        transaction.setValue(transactionDTO.getValue());

        transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }

}
