package com.zaurtregulov.spring.rest.exceptionHandling;

public class NoSuchEmployeeException extends RuntimeException{

    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
