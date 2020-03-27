package pks.bank.exception;

public class NotEnoughMoneyInTheBankException extends Exception {
    /*
    Это исключение необходимо обрабатывать, ибо оно сигнализирует нам о том, что дальнейшая работа потоков банковских юзеров бесполезна.
    По возникновении этого исключения необходимо инициировать прерывание выполнения.

    Переделаваю на Exception
     */

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
