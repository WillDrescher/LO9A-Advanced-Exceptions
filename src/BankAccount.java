public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws NegativeBalanceException {
        if (amount > balance) {
            double newBalance = balance - amount; // this will be negative
            throw new NegativeBalanceException(newBalance);
        } else {
            balance -= amount;
        }
    }

    public void quickWithdraw(double amount) throws NegativeBalanceException {
        if (amount > balance) {
            throw new NegativeBalanceException();
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}