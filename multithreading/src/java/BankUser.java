class BankUser extends Thread{
    Bank bank;

    BankUser(Bank bank) {
        this.bank = bank;
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
                this.makeTransfer(1);
            } catch (NotEnoughMoneyException e) {
                System.out.println("Деньги кончились");
                e.printStackTrace();
                break;
            }
        }
    }
}
