public class TerminalServer {
    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void replenishAccount(int sum) throws Exception{
        if (sum%100 == 0)
            if (sum > 0)
                this.balance += sum;
            else throw new Exception();//уточнить какой именно сумма не корректная
        else throw new Exception();//уточнить какой именно сумма не кратна 100
    }

    public int withdrawMoney(int sum) throws Exception {
        if (sum%100 == 0)
            if (sum > 0)
                if (this.balance - sum >= 0){
                    this.balance -= sum;
                    return sum;
                }
                else throw new Exception();//уточнить какой именно не достаточно денег
            else throw new Exception();//уточнить какой именно сумма не корректная
        else throw new Exception();//уточнить какой именно сумма не кратна 100
    }
}
