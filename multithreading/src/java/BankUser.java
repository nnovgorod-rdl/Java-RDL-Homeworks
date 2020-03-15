class BankUser extends Thread{
    String name;
    Bank bank;

    BankUser(Bank bank, String name) {
        this.bank = bank;
        this.name = name;
    }

    public void makeTransfer (int moneToTransfer) throws NotEnoughMoneyException {
        if(bank.hasEnoughMoney(moneToTransfer)){
                this.bank.transferMoney(moneToTransfer);
        }
        else {
         throw new NotEnoughMoneyException("Денег нет!");}
    }

    @Override
    public void run()
    {
        while (true) {
            try {
                System.out.println(this.name);
                this.makeTransfer(5);
            } catch (NotEnoughMoneyException e) {
                System.out.println("Деньги кончились");
                e.printStackTrace();
                break;
            }
        }
    }
}
