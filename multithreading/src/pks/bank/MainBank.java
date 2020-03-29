package pks.bank;

import pks.bank.work.Bank;
import pks.bank.work.BankUser;

import java.util.ArrayList;

public class MainBank {
    static ArrayList<BankUser> bankUserArrayList = new ArrayList<>();
    static ArrayList<Thread> threadsArrayList = new ArrayList<>();
    static final int MAX_BANK_USERS = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(1000);
        System.out.println(bank.getMoneyAmount());

        createBankUsers(bank);

        createThreads(bankUserArrayList);

        startThreadsBankUsers();

        /*
        Выглядит так, словно все, что выше можно было сделать при помощи коллекции и цикла.
        Лаконичная запись предпочтительнее, при условии сохранения легкости понимания логики.

        Сделал
         */

        /*
        +        while (first.isAlive() || second.isAlive()
        +                || third.isAlive() || fourth.isAlive()
        +                || fifth.isAlive() || sixth.isAlive()
        +                || seventh.isAlive() || eighth.isAlive()
        +                || ninth.isAlive() || tenth.isAlive()) {
        +            try {
        +                Thread.sleep(1000);
        +            } catch (Exception e) {
        +                e.printStackTrace();

        Зачем здесь цикл?
        Что произойдет с остальными потоками если этот тред завершит свое выполнение?

        Остальные потоки продолжат свое "выполнение". Вы правы, цикл к данной ситуации попросту не
        нужен. Убрал.
        */
    }

    static void createBankUsers(Bank bank) {
        /*
        Блин... такой "ЛЯП" был, в прошлом моем ручном "создании" BankUsers
        > +        Thread sixth = new Thread(bankUserThird);
        +        Thread seventh = new Thread(bankUserThird);
        +        Thread eighth = new Thread(bankUserThird);
        +        Thread ninth = new Thread(bankUserThird);
        +        Thread tenth = new Thread(bankUserThird);
         */
        for (int i = 1; i <= MAX_BANK_USERS; i++) {
            bankUserArrayList.add(new BankUser(bank, ("BankUser #" + i)));
        }
    }

    static void createThreads(ArrayList<BankUser> list) {
        for (BankUser bankUser : list) {
            threadsArrayList.add(new Thread(bankUser));
        }
    }

    private static void startThreadsBankUsers() {
        for (Thread thread : threadsArrayList) {
            thread.start();
        }
    }
}
