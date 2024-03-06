package com.svaan1.backendcryptography.converter;

import com.svaan1.backendcryptography.dto.TransactionDTO;
import com.svaan1.backendcryptography.dto.TransactionResponse;
import com.svaan1.backendcryptography.model.Transaction;
import com.svaan1.backendcryptography.security.StringEncoder;

public class TransactionConverter {

    private final StringEncoder stringEncoder = new StringEncoder();

    public TransactionResponse toResponse(Transaction transaction) {
        return TransactionResponse.builder()
                .id(transaction.getId())
                .userDocument(stringEncoder.decrypt(transaction.getUserDocument()))
                .creditCardToken(stringEncoder.decrypt(transaction.getCreditCardToken()))
                .value(transaction.getValue())
                .build();
    }

    public Transaction toEntity(TransactionDTO transactionDTO) {
        return Transaction.builder()
                .userDocument(stringEncoder.encrypt(transactionDTO.getUserDocument()))
                .creditCardToken(stringEncoder.encrypt(transactionDTO.getCreditCardToken()))
                .value(transactionDTO.getValue())
                .build();
    }
}
