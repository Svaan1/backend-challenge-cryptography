package com.svaan1.backendcryptography.dto;

import com.svaan1.backendcryptography.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private String userDocument;
    private String creditCardToken;
    private Long value;

    public Transaction toEntity() {
        return Transaction.builder()
                .userDocument(userDocument)
                .creditCardToken(creditCardToken)
                .value(value)
                .build();
    }
}
