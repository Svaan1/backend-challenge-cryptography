package com.svaan1.backendcryptography.service;

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

    private final TransactionRepository transactionRepository;

    public List<TransactionResponseDTO> listTransactions() {
        return transactionRepository.findAll().stream().map(this::convertEntityToResponse).toList();
    }

    public TransactionResponseDTO getTransaction(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow();

        return convertEntityToResponse(transaction);
    }

    public void createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = convertDTOtoEntity(transactionDTO);

        transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    public Transaction convertDTOtoEntity(TransactionDTO transactionDTO) {
        return Transaction.builder()
                .userDocument(transactionDTO.getUserDocument())
                .creditCardToken(transactionDTO.getCreditCardToken())
                .value(transactionDTO.getValue())
                .build();
    }

    public TransactionResponseDTO convertEntityToResponse(Transaction transaction) {
        return TransactionResponseDTO.builder()
                .id(transaction.getId())
                .userDocument(transaction.getUserDocument())
                .creditCardToken(transaction.getCreditCardToken())
                .value(transaction.getValue())
                .build();
    }

}
