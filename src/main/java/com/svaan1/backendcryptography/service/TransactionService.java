package com.svaan1.backendcryptography.service;

import com.svaan1.backendcryptography.converter.TransactionConverter;
import com.svaan1.backendcryptography.dto.TransactionDTO;
import com.svaan1.backendcryptography.dto.TransactionResponse;
import com.svaan1.backendcryptography.exception.TransactionNotFoundException;
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

    public List<TransactionResponse> listTransactions() {
        return transactionRepository.findAll().stream().map(transactionConverter::toResponse).toList();
    }

    public TransactionResponse getTransaction(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(TransactionNotFoundException::new);

        return transactionConverter.toResponse(transaction);
    }

    public TransactionResponse createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = transactionConverter.toEntity(transactionDTO);

        transactionRepository.save(transaction);

        return transactionConverter.toResponse(transaction);
    }

    public TransactionResponse updateTransaction(Long transactionId, TransactionDTO transactionDTO) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(TransactionNotFoundException::new);

        transaction.setUserDocument(transactionDTO.getUserDocument());
        transaction.setCreditCardToken(transactionDTO.getCreditCardToken());
        transaction.setValue(transactionDTO.getValue());

        transactionRepository.save(transaction);

        return transactionConverter.toResponse(transaction);
    }

    public void deleteTransaction(Long transactionId) { transactionRepository.deleteById(transactionId); }

}
