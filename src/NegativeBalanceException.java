import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Julia Kolomiitseva
// This is a custom exception that gets thrown when a withdrawal
// would cause a negative balance. It has two constructors:
// one general error message, and one that includes how much
// the withdrawal exceeds the balance. The detailed constructor
// also writes the error message to a logfile.
// The toString method gives a custom message when printed.
public class NegativeBalanceException extends Exception {

    private double negativeBalance;

    public NegativeBalanceException() {
        super("Error: negative balance");
        this.negativeBalance = 0.0;
    }

    public NegativeBalanceException(double negativeBalance) {
        super("Amount exceeds balance by " + negativeBalance);
        this.negativeBalance = negativeBalance;
        writeToLog("Amount exceeds balance by " + negativeBalance);
    }

    private void writeToLog(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter("logfile.txt", true))) {
            out.println(message);
        } catch (IOException e) {
        }
    }

    public double getNegativeBalance() {
        return negativeBalance;
    }

    @Override
    public String toString() {
        return "Balance of " + negativeBalance + " not allowed";
    }
}