public class TerminalServer {
    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void replenishAccount(int amount) throws Exception{
        if (amount%100 == 0)
            if (amount >= 0)
                this.balance += amount;
            else throw new NegativeAmountException();
        else throw new IncorrectAmountException();
    }

    public int withdrawMoney(int amount) throws Exception {
        if (amount%100 == 0)
            if (amount >= 0)
                if (this.balance - amount >= 0){
                    this.balance -= amount;
                    return amount;
                }
                else throw new NotEnoughMoneyException();
            else throw new NegativeAmountException();
        else throw new IncorrectAmountException();
    }
}
