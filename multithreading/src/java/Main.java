public class Main {
    public static void main(String[] args) {
        Bank b = new Bank(500);
        BankUser bu1 = new BankUser(b);
        BankUser bu2 = new BankUser(b);
        BankUser bu3 = new BankUser(b);
        BankUser bu4 = new BankUser(b);
            bu1.start();
            bu2.start();
            bu3.start();
            bu4.start();

    }
}
