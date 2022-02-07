package com.principal.exception;

import java.time.LocalDateTime;

public class CustomException extends Throwable {
    private String cause;
    private LocalDateTime time;

    public CustomException(String cause, LocalDateTime time) {
        this.cause = cause;
        this.time = time;
    }


}