package com.bridgelabz.exceptions;

public class InvalidNameException extends Exception{

    public InvalidNameException() {
        super();
    }

    public InvalidNameException(String message) {
        super(message);
    }
}