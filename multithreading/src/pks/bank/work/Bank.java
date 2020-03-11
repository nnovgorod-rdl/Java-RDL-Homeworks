package pks.bank.work;

import pks.bank.exception.NotEnoughMoneyInTheBankException;

public class Bank {
    private final int MONEY_IN_THE_BANK = 5000;
    private int moneyAmount;

    //Сразу установим сумму в банке
    public Bank() {
        this.moneyAmount = MONEY_IN_THE_BANK;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void transferMoney(int amount) {
        if ((moneyAmount - amount) < 0) {
            throw new NotEnoughMoneyInTheBankException();
        } else {
            moneyAmount -= amount;
        }
    }

    public boolean hasEnoughMoney(int amount) {
        return amount <= moneyAmount;
    }
}
