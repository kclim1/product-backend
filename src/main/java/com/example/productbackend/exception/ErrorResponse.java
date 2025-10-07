package com.example.productbackend.exception;

import java.time.Instant;

public record ErrorResponse(
    String message,
    String error,
    int statusCode,
    String path,
    Instant timeStamp
) {
}
