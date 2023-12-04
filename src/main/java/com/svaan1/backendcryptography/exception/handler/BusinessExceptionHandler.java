package com.svaan1.backendcryptography.exception.handler;

import com.svaan1.backendcryptography.dto.ErrorMessage;
import com.svaan1.backendcryptography.exception.TransactionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class BusinessExceptionHandler {

    // Default Exceptions

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String detail = "Invalid request";
        List<String> subErrors = exception.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();

        ErrorMessage errorMessage = new ErrorMessage(status, detail, subErrors);

        return ResponseEntity.status(status).body(errorMessage);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadable() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String detail = "Missing request body";

        ErrorMessage errorMessage = new ErrorMessage(status, detail);

        return ResponseEntity.status(status).body(errorMessage);
    }

    // Custom Exceptions

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleProductNotFound() {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String detail = "Resource not found";

        ErrorMessage errorMessage = new ErrorMessage(status, detail);

        return ResponseEntity.status(status).body(errorMessage);
    }

}
