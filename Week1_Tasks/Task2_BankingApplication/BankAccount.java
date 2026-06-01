import java.math.BigDecimal;
import java.util.ArrayList;

public class BankAccount {

    private String accountNumber;
    private String holderName;
    private BigDecimal balance;
    private ArrayList<String> transactionHistory;

    public BankAccount(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = BigDecimal.ZERO;
        this.transactionHistory = new ArrayList<>();

        transactionHistory.add("Account Opened with Balance: ₹0");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        balance = balance.add(amount);

        transactionHistory.add("Deposited ₹" + amount);

        System.out.println("Deposit Successful.");
    }

    public void withdraw(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        if (amount.compareTo(balance) > 0) {
            System.out.println("Insufficient Funds.");
            return;
        }

        balance = balance.subtract(amount);

        transactionHistory.add("Withdrawn ₹" + amount);

        System.out.println("Withdrawal Successful.");
    }

    public void printStatement() {

        System.out.println("\n===== ACCOUNT STATEMENT =====");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.println("Balance        : ₹" + balance);

        System.out.println("\nTransaction History:");

        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}