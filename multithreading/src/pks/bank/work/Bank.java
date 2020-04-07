package pks.bank.work;

import pks.bank.exception.NotEnoughMoneyInTheBankException;

import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
    private final AtomicInteger moneyAmount;

    /*
    +    private final int MONEY_IN_THE_BANK = 1000;

    Не понимаю для чего здесь эта константа. В лучшем случае ее можно вынести в класс с функцией мэйн и
    передавать сюда как параметр конструктора.
    Либо напрямую присваивать в конструкторе значение.

    Убрал
     */
    public Bank(int moneyAmount) {
        this.moneyAmount = new AtomicInteger(moneyAmount);
    }

    public int getMoneyAmount() {
        return moneyAmount.get();
    }

    /*
    Synchronized избыточен для геттера. Здесь важна видимость.
    Как можно добиться того, чтобы все потоки видели актуальное значение?

    Надеюсь я корректно сделал через AtomicInteger :-)
     */

    public synchronized void transferMoney(int amount) throws NotEnoughMoneyInTheBankException {
        if ((moneyAmount.get() - amount) < 0) {
            throw new NotEnoughMoneyInTheBankException();
        } else {
            moneyAmount.addAndGet(-amount);
        }
    }

    /*
    Результат проверок (строки 19 и 34) внутри synchronized функции должен совпадать, верно?
    Кажется, что какая-то из проверок лишняя.
    Почему в одном случае return, а в другом бросаем исключение?

    Убрал лишнее.
     */

    public synchronized boolean hasEnoughMoney(int amount) {
        return amount <= moneyAmount.get();
    }
}
