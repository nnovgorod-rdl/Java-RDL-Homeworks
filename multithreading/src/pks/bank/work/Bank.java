package pks.bank.work;

import pks.bank.exception.NotEnoughMoneyInTheBankException;

import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
    private AtomicInteger moneyAmount;

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

    public synchronized void transferMoney(int amount) throws NotEnoughMoneyInTheBankException {
        /*
        Как все таки "правильнее"
        if (moneyAmount.addAndGet(-amount) < 0) {
        или
        if ((moneyAmount.get() - amount) < 0) {
        ???
         */
        if ((moneyAmount.get() - amount) < 0) {
            throw new NotEnoughMoneyInTheBankException();
        } else {
            moneyAmount.addAndGet(-amount);
        }
    }

    public synchronized boolean hasEnoughMoney(int amount) {
        return amount <= moneyAmount.get();
    }
}
