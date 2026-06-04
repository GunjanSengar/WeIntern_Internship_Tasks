public class BankAccount {

    private double balance;

    public BankAccount() {
        balance = 0.0;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }

        balance += amount;

        System.out.println("Deposit Successful.");
        System.out.printf("Updated Balance: %.2f%n", balance);
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient Funds.");
            return;
        }

        balance -= amount;

        System.out.println("Withdrawal Successful.");
        System.out.printf("Updated Balance: %.2f%n", balance);
    }

    public double getBalance() {
        return balance;
    }
}