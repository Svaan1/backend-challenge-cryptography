package com.svaan1.backendcryptography.model;

import com.svaan1.backendcryptography.dto.TransactionResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="transaction")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String userDocument;
    private String creditCardToken;
    private Long value;

    public TransactionResponseDTO toResponse() {
        return TransactionResponseDTO.builder()
                .id(id)
                .userDocument(userDocument)
                .creditCardToken(creditCardToken)
                .value(value)
                .build();
    }

}
