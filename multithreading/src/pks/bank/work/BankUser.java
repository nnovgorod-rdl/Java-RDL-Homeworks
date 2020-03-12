package pks.bank.work;

import java.util.Random;

public class BankUser implements Runnable {
    private Bank bank;
    public String nameBankUser;
    private final Random random = new Random();
    private final int MAX_MONEY_TO_TRANSFER = 10;
    private final int TIME_TO_SLEEP = 10;
    /*
    В Bank все методы сделал synchronized, но не давать потоку "спать"
    выставив TIME_TO_SLEEP = 10, например, у меня все равно вывалилось
    NotEnoughMoneyInTheBankException, видимо некорректная реализация метода run
    1-й поток спрашивает - bank.hasEnoughMoney(moneyToTransfer), получает true, т.к. деньги есть
    2-поток снимает деньги, со счета
    1-й поток снимает деньги, и вылетат с NotEnoughMoneyInTheBankException

    Теперь у меня ситуация наоборот, вчера я не мог воспроизвести ошибку, сегодня не могу
    понять, как ее решить
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
