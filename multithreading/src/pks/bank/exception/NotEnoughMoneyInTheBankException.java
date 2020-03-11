package pks.bank.exception;

public class NotEnoughMoneyInTheBankException extends RuntimeException {
    //RuntimeException выбран, что бы не требовалось try/catch

    public NotEnoughMoneyInTheBankException() {
        super();
    }

    public NotEnoughMoneyInTheBankException(String message) {
        super(message);
    }

    public NotEnoughMoneyInTheBankException(String message, Throwable cause) {
        super(message, cause);
    }
}
