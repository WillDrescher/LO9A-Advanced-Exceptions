// Julia Kolomiitseva and Will Drescher
// This BankAccount class stores a balance and allows withdrawals.
// If someone tries to withdraw more than what’s available,
// it throws a custom NegativeBalanceException.
// The withdraw method passes how much the amount exceeds the balance,
// while quickWithdraw throws a more general exception.
// Both methods use a throws clause so the error is handled elsewhere.

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws NegativeBalanceException {
        if (amount > balance) {
            double newBalance = amount - balance; // this will be negative
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