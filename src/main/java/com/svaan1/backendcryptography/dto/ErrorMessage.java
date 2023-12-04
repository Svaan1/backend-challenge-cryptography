package com.svaan1.backendcryptography.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

@Data
public class ErrorMessage {
    private int status;
    private String detail;
    private List<String> subErrors;
    private Instant timestamp;

    public ErrorMessage(HttpStatus status, String detail) {
        setStatus(status.value());
        setDetail(detail);
        setTimestamp(Instant.now());
    }

    public ErrorMessage(HttpStatus status, String detail, List<String> subErrors) {
        setStatus(status.value());
        setDetail(detail);
        setSubErrors(subErrors);
        setTimestamp(Instant.now());
    }

}