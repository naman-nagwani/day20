package com.bridgelabz.exceptions;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super();
    }

    public InvalidPasswordException(String message) {
        super(message);
    }
}
