package pks.bank.work;

import pks.bank.exception.NotEnoughMoneyInTheBankException;

import java.util.Random;

public class BankUser implements Runnable {
    private final Random random = new Random();
    private final int MAX_MONEY_TO_TRANSFER = 10;
    private final int TIME_TO_SLEEP_MS = 10;

    private Bank bank;
    public String nameBankUser;

    /*
    Константы обычно объявляют выше проперти класса.

    В случае констант, где имеет значение в чем именно это задано,
    имеет смысл указывать единицы измерения в имени. E.g.: TIME_TO_SLEEP_MS

    Сделал
     */

    public BankUser(Bank bank, String nameBankUser) {
        this.bank = bank;
        this.nameBankUser = nameBankUser;
    }

    @Override
    public void run() {
        System.out.println(nameBankUser + " is started");
        try {
            while (bank.getMoneyAmount() > 0) {
                int moneyToTransfer = random.nextInt(MAX_MONEY_TO_TRANSFER) + 1;

                if (bank.hasEnoughMoney(moneyToTransfer)) {
                    bank.transferMoney(moneyToTransfer);
                    System.out.println(nameBankUser + " get " + moneyToTransfer + " money");
                } else {
                    System.out.println(nameBankUser + " wants too much money");
                }

                System.out.println("In the Bank - " + bank.getMoneyAmount() + " money");
                System.out.println("");

                int sleep = random.nextInt(TIME_TO_SLEEP_MS);
                Thread.sleep(sleep);
            }
        } catch (NotEnoughMoneyInTheBankException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
