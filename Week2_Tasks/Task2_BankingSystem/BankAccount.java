import java.util.ArrayList;

public abstract class BankAccount {

    protected int accountNumber;
    protected String holderName;
    protected double balance;

    protected ArrayList<Transaction> transactions =
            new ArrayList<>();

    public BankAccount(
            int accountNumber,
            String holderName,
            double balance) {

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        balance += amount;

        transactions.add(
                new Transaction("Deposit", amount));

        System.out.println("Deposit successful.");
    }

    public abstract void withdraw(double amount);

    public void printStatement() {

        System.out.println("\nAccount Number: "
                + accountNumber);

        System.out.println("Account Holder: "
                + holderName);

        System.out.println("Current Balance: ₹"
                + balance);

        System.out.println("\nTransaction History:");

        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}