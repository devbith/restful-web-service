package com.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {

    LocalDateTime timeStamp;
    String message;
    String description;

    public ExceptionResponse(LocalDateTime timeStamp, String message, String description) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.description = description;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
