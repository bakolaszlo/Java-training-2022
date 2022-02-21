package com.example.springboot.controller;

import com.example.springboot.exception.ResourcesNotFoundException;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({ResourcesNotFoundException.class})
    protected ResponseEntity<Object> handleResourceNotFound(RuntimeException ex){
        final Map<String, Object> body = Map.of("Exception reason: ", ex.getMessage(), "Timestamp: ", LocalDateTime.now());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}
