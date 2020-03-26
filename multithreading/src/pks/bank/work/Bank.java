package pks.bank.work;

import pks.bank.exception.NotEnoughMoneyInTheBankException;

public class Bank {
    private int moneyAmount;

    /*
    +    private final int MONEY_IN_THE_BANK = 1000;

    Не понимаю для чего здесь эта константа. В лучшем случае ее можно вынести в класс с функцией мэйн и
    передавать сюда как параметр конструктора.
    Либо напрямую присваивать в конструкторе значение.

    Убрал
     */
    public Bank(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public synchronized int getMoneyAmount() {
        return moneyAmount;
    }

    public synchronized void transferMoney(int amount) {
        if (!hasEnoughMoney(amount)) {
            return;
        }
        /*
        Конечно, костыльно, но перед тем, как снять, проверяем, а хватает ли денег - вчерашнее 12-03-2020
        Хотя, сейчас думаю, что это не костыль.
        Метод run написан согласно ТЗ :-)
        И, потоки, все делают "логически правильно"
        1-й поток спрашивает - bank.hasEnoughMoney(moneyToTransfer), получает true, т.к. деньги есть
        2-поток снимает деньги, со счета. Он уже раньше проверил, денег хватает.
        1-й поток снимает деньги, и вылетат с NotEnoughMoneyInTheBankException

        Поэтому или переделываем run, или дополнительная проверка, что и сделано :-)
         */

        if ((moneyAmount - amount) < 0) {
            throw new NotEnoughMoneyInTheBankException();
        } else {
            moneyAmount -= amount;
        }
    }

    public synchronized boolean hasEnoughMoney(int amount) {
        return amount <= moneyAmount;
    }
}
