public class Bank {
    private int moneyAmount;

   public void transferMoney(int amount) throws NotEnoughMoneyException {
        if (amount > this.moneyAmount)
            throw new NotEnoughMoneyException("Not enough money in the account");
        else {
            this.setMoneyAmount(this.getMoneyAmount()-amount);
            System.out.println("Списано 5 тэнге, на счету осталось - "+this.getMoneyAmount() + "денег");
        }
    }

    public boolean hasEnoughMoney(int amount) {
        return amount < this.moneyAmount;
    }

    public Bank(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
