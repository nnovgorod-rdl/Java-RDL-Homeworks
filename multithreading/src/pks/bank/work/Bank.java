package pks.bank.work;

import pks.bank.exception.NotEnoughMoneyInTheBankException;
import pks.bank.exception.ZeroMoneyInTheBankException;

class Bank {
    private int moneyAmount;

    public void setMoneyAmount(int moneyAmount) {
        if (moneyAmount <= 0) {
            throw new ZeroMoneyInTheBankException();
        } else {
            this.moneyAmount = moneyAmount;
        }
    }

    public void transferMoney(int amount) {
        if ((moneyAmount - amount) < 0) {
            throw new NotEnoughMoneyInTheBankException();
        } else {
            moneyAmount -= amount;
        }
    }

    public boolean hasEnoughMoney(int amount) {
        return amount >= moneyAmount;
    }
}
