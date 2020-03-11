package pks.bank;

import pks.bank.work.Bank;
import pks.bank.work.BankUser;

public class MainBank {
    static BankUser bankUserFirst;
    static BankUser bankUserSecond;

    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println(bank.getMoneyAmount());

        bankUserFirst = new BankUser(bank, "John");
        bankUserSecond = new BankUser(bank, "Bob");

        Thread first = new Thread(bankUserFirst);
        Thread second = new Thread(bankUserSecond);

        first.start();
        second.start();

        while (first.isAlive() || second.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
