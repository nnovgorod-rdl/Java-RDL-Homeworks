import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
    private AtomicInteger moneyAmount;

   public void transferMoney(int amount) throws NotEnoughMoneyException {
        if (amount > this.moneyAmount.get())
            throw new NotEnoughMoneyException("Not enough money in the account");
        else {
            this.setMoneyAmount(new AtomicInteger(this.getMoneyAmount().get()-amount));
            System.out.println("Списано 5 тэнге, на счету осталось - "+this.getMoneyAmount().get() + "денег");
        }
    }

   public boolean hasEnoughMoney(int amount) {
        return amount < this.moneyAmount.get();
    }

    public Bank(int moneyAmount) {
        this.moneyAmount = new AtomicInteger(moneyAmount);
    }

    public AtomicInteger getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(AtomicInteger moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
