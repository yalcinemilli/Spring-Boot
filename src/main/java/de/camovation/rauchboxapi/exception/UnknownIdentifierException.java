package de.camovation.rauchboxapi.exception;

public class UnknownIdentifierException extends Exception{
    public UnknownIdentifierException() {
    }

    public UnknownIdentifierException(String message) {
       super(message);
    }

    public UnknownIdentifierException(String message, Throwable cause) {
       super(message, cause);
    }
}
