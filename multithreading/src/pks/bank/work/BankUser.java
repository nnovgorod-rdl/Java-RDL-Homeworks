package pks.bank.work;

import pks.bank.exception.NotEnoughMoneyInTheBankException;

import java.util.Random;

import static java.lang.System.*;

public class BankUser implements Runnable {
    private final Random random = new Random();
    private final int MAX_MONEY_TO_TRANSFER = 10;
    private final int TIME_TO_SLEEP_MS = 10;

    private final Bank bank;
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
        out.println(nameBankUser + " is started");
        try {
            while (bank.getMoneyAmount() > 0) {
                // +1 добавлен, что-бы всегда хоть что то BankUser пытался звбрать
                int moneyToTransfer = random.nextInt(MAX_MONEY_TO_TRANSFER) + 1;

                if (bank.hasEnoughMoney(moneyToTransfer)) {
                    bank.transferMoney(moneyToTransfer);
                    out.println(nameBankUser + " get " + moneyToTransfer + " money");
                } else {
                    out.println(nameBankUser + " wants too much money");
                }

                out.println("In the Bank : " + bank.getMoneyAmount() + " money");
                out.println();

                int sleep = random.nextInt(TIME_TO_SLEEP_MS);
                Thread.sleep(sleep);
            }
        } catch (NotEnoughMoneyInTheBankException e) {
            /*
            Это исключение необходимо обрабатывать, ибо оно сигнализирует нам о том, что дальнейшая работа потоков банковских юзеров бесполезна.
            По возникновении этого исключения необходимо инициировать прерывание выполнения.

            Ничего страшного в NotEnoughMoneyInTheBankException нет - главное правильно его обработать завершив аккуратно выполнение потока.
            Возможно формулировка сбивает с толку, но исходя из здравого смысла так получается.

            Не хватает !Thread.currentThread().isInterrupted().

            Два момента:
            нас интересует InterruptedException исключение, которое нужно обработать особым образом;
             необходимо пометить поток как прерванный: thread.currentthread().interrupt().

            Помечаю поток который "списывает со счета в минус"
             */
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
