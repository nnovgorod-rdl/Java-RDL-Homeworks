package io.humb1t;

public class LifeCycleActionStartException extends Exception {
    public LifeCycleActionStartException() {
        super();
    }

    public LifeCycleActionStartException(String message) {
        super(message);
    }

    public LifeCycleActionStartException(String message, Throwable cause) {
        super(message, cause);
    }
}
