package com.example.productbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleResponseStatusException(
            ResponseStatusException ex,
            WebRequest request
    ) {
        // Cast HttpStatusCode → HttpStatus
        HttpStatus status = (HttpStatus) ex.getStatusCode();
        ErrorResponse error = new ErrorResponse(
                ex.getReason(),                                   // "Product not found"
                status.getReasonPhrase(),             // "Not Found"
                ex.getStatusCode().value(),                       // 404
                request.getDescription(false).replace("uri=", ""),// "/api/v1/products/123"
                Instant.now()                                     // current timestamp
        );

        return ResponseEntity.status(ex.getStatusCode()).body(error);
    }
}

