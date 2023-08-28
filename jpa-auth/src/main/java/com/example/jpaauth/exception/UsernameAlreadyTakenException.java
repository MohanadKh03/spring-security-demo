package com.example.jpaauth.exception;

public class UsernameAlreadyTakenException extends RuntimeException{
    public UsernameAlreadyTakenException() {
        super();
    }

    public UsernameAlreadyTakenException(String message) {
        super(message);
    }
}
