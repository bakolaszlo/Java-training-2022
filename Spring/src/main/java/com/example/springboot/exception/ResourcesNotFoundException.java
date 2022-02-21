package com.example.springboot.exception;

public class ResourcesNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourcesNotFoundException(String message) {
        super(message);
    }
}
