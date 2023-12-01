package com.svaan1.backendcryptography.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TransactionDTO {
    private String userDocument;
    private String creditCardToken;
    private Long value;
}
