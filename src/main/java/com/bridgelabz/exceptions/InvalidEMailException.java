package com.bridgelabz.exceptions;

public class InvalidEMailException extends Exception {
    public InvalidEMailException() {
        super();
    }

    public InvalidEMailException(String message) {
        super(message);
    }
}
