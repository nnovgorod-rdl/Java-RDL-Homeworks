package io.humb1t;

public class MyOwnException extends Exception {
    public MyOwnException(String message, Throwable cause) {
        super(message, cause);
    }
}