package com.amukoski.zip.exception;

public class InvalidZipCodeException extends Exception {

    public InvalidZipCodeException() {
    }

    public InvalidZipCodeException(String message) {
        super(message);
    }
}
