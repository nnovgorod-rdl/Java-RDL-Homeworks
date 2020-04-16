package pks.chain.exceptions;

public class NotOurNumber extends Exception{
    public NotOurNumber() {
        super();
    }

    public NotOurNumber(String message) {
        super(message);
    }

    public NotOurNumber(String message, Throwable cause) {
        super(message, cause);
    }
}
