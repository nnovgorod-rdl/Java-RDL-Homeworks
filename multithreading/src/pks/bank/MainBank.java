package pks.bank;

import pks.bank.work.Bank;
import pks.bank.work.BankUser;

public class MainBank {
    static BankUser bankUserFirst;
    static BankUser bankUserSecond;
    static BankUser bankUserThird;
    static BankUser bankUserFourth;
    static BankUser bankUserFifth;
    static BankUser bankUserSixth;
    static BankUser bankUserSeventh;
    static BankUser bankUserEighth;
    static BankUser bankUserNinth;
    static BankUser bankUserTenth;

    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println(bank.getMoneyAmount());

        bankUserFirst = new BankUser(bank, "01");
        bankUserSecond = new BankUser(bank, "02");
        bankUserThird = new BankUser(bank, "03");
        bankUserFourth = new BankUser(bank, "04");
        bankUserFifth = new BankUser(bank, "05");
        bankUserSixth = new BankUser(bank, "06");
        bankUserSeventh = new BankUser(bank, "07");
        bankUserEighth = new BankUser(bank, "08");
        bankUserNinth = new BankUser(bank, "09");
        bankUserTenth = new BankUser(bank, "10");

        Thread first = new Thread(bankUserFirst);
        Thread second = new Thread(bankUserSecond);
        Thread third = new Thread(bankUserThird);
        Thread fourth = new Thread(bankUserThird);
        Thread fifth = new Thread(bankUserThird);
        Thread sixth = new Thread(bankUserThird);
        Thread seventh = new Thread(bankUserThird);
        Thread eighth = new Thread(bankUserThird);
        Thread ninth = new Thread(bankUserThird);
        Thread tenth = new Thread(bankUserThird);

        first.start();
        second.start();
        third.start();
        fourth.start();
        fifth.start();
        sixth.start();
        seventh.start();
        eighth.start();
        ninth.start();
        tenth.start();

        while (first.isAlive() || second.isAlive()
                || third.isAlive() || fourth.isAlive()
                || fifth.isAlive() || sixth.isAlive()
                || seventh.isAlive() || eighth.isAlive()
                || ninth.isAlive() || tenth.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
