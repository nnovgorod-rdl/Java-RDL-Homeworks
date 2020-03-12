package pks.bank.work;

import java.util.Random;

public class BankUser implements Runnable {
    private Bank bank;
    public String nameBankUser;
    private final Random random = new Random();
    private final int MAX_MONEY_TO_TRANSFER = 10;
    private final int TIME_TO_SLEEP = 10;

    public BankUser(Bank bank, String nameBankUser) {
        this.bank = bank;
        this.nameBankUser = nameBankUser;
    }

    @Override
    public void run() {
        System.out.println(nameBankUser + " is started");
        try {
            while (bank.getMoneyAmount() > 0) {
                int moneyToTransfer = random.nextInt(MAX_MONEY_TO_TRANSFER);

                if (bank.hasEnoughMoney(moneyToTransfer)) {
                    bank.transferMoney(moneyToTransfer);
                    System.out.println(nameBankUser + " get " + moneyToTransfer + " money");
                } else {
                    System.out.println(nameBankUser + " wants too much money");
                }
                System.out.println("In the Bank - " + bank.getMoneyAmount() + " money");
                System.out.println("");
                int sleep = random.nextInt(TIME_TO_SLEEP);
                Thread.sleep(sleep);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
