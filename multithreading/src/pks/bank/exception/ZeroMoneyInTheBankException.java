package pks.bank.exception;

public class ZeroMoneyInTheBankException extends RuntimeException {
    //RuntimeException выбран, что бы не требовалось try/catch
    public ZeroMoneyInTheBankException() {
        super();
    }

    public ZeroMoneyInTheBankException(String message) {
        super(message);
    }

    public ZeroMoneyInTheBankException(String message, Throwable cause) {
        super(message, cause);
    }
}
