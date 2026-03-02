import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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