package BankAndBankUsers;

public class Main {
    public static void main(String[] args) {
        Bank b = new Bank(500);
        BankUser bu1 = new BankUser(b, "thread 1");
        BankUser bu2 = new BankUser(b, "thread 2");
        bu1.start();
        try {
            bu1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bu2.start();
    }
}