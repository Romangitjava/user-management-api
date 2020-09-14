package com.example.rolemanagement.exception;

import java.time.LocalDate;

public class ErrorMessage {

    private final int statusCode;
    private final LocalDate timestamp;
    private final String message;
    private final String path;

    public ErrorMessage(LocalDate timestamp, int statusCode, String message, String path) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.message = message;
        this.path = path;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}

