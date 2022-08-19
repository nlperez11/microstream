package com.demo.microstream.config;

import com.demo.microstream.exception.CarException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(CarException.class)
    public ResponseEntity<Message> handle(CarException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message(exception.getMessage()));
    }

    @Data
    @AllArgsConstructor
    private static class Message {
        String message;
    }
}
