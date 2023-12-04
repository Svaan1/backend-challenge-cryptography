package com.svaan1.backendcryptography.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    @NotBlank(message = "User document is empty")
    @NotNull(message = "User document is null")
    private String userDocument;

    @NotBlank(message = "Credit card token is empty")
    @NotNull(message = "Credit card token is null")
    private String creditCardToken;

    @NotNull(message = "Value is null")
    private Long value;

}
