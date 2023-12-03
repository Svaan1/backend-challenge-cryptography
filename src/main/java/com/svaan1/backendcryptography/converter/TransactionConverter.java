package com.svaan1.backendcryptography.converter;

import com.svaan1.backendcryptography.dto.TransactionDTO;
import com.svaan1.backendcryptography.dto.TransactionResponseDTO;
import com.svaan1.backendcryptography.model.Transaction;

public class TransactionConverter {

    public TransactionResponseDTO toResponse(Transaction transaction) {
        return TransactionResponseDTO.builder()
                .id(transaction.getId())
                .userDocument(transaction.getUserDocument())
                .creditCardToken(transaction.getCreditCardToken())
                .value(transaction.getValue())
                .build();
    }

    public Transaction toEntity(TransactionDTO transactionDTO) {
        return Transaction.builder()
                .userDocument(transactionDTO.getUserDocument())
                .creditCardToken(transactionDTO.getCreditCardToken())
                .value(transactionDTO.getValue())
                .build();
    }
}
