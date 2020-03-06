package io.humb1t;

public class NotCorrectAgeException extends RuntimeException {
    public NotCorrectAgeException() {
        super();
    }

    public NotCorrectAgeException(String message) {
        super(message);
    }

    public NotCorrectAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
