// Will Drescher and Julia Kolomiitseva
// This ATM class tests our BankAccount.
// It creates an account with $500 and tries to withdraw $600 twice.
// Each attempt is inside a try-catch to show how the custom
// NegativeBalanceException gets thrown and handled.
// main just runs the test.

public class ATM {

    private BankAccount account;

    public ATM() {
        account = new BankAccount(500.0);
    }

    public void handleTransactions() {
        try {
            account.withdraw(600.0);
        } catch (NegativeBalanceException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }

        try {
            account.quickWithdraw(600.0);
        } catch (NegativeBalanceException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.handleTransactions();
    }
}