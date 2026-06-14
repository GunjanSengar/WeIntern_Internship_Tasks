import java.util.HashMap;

public class Bank {

    private HashMap<Integer, BankAccount> accounts =
            new HashMap<>();

    private int nextAccountNumber = 1001;

    public void createSavingsAccount(
            String name,
            double balance) {

        BankAccount account =
                new SavingsAccount(
                        nextAccountNumber,
                        name,
                        balance);

        accounts.put(
                nextAccountNumber,
                account);

        System.out.println(
                "Savings Account Created.");

        System.out.println(
                "Account Number: "
                        + nextAccountNumber);

        nextAccountNumber++;
    }

    public void createCurrentAccount(
            String name,
            double balance) {

        BankAccount account =
                new CurrentAccount(
                        nextAccountNumber,
                        name,
                        balance);

        accounts.put(
                nextAccountNumber,
                account);

        System.out.println(
                "Current Account Created.");

        System.out.println(
                "Account Number: "
                        + nextAccountNumber);

        nextAccountNumber++;
    }

    public BankAccount findAccount(
            int accountNumber) {

        return accounts.get(accountNumber);
    }

    public void transfer(
            int from,
            int to,
            double amount) {

        BankAccount sender =
                accounts.get(from);

        BankAccount receiver =
                accounts.get(to);

        if (sender == null ||
                receiver == null) {

            System.out.println(
                    "Account not found.");
            return;
        }

        double before =
                sender.getBalance();

        sender.withdraw(amount);

        if (sender.getBalance() < before) {

            receiver.deposit(amount);

            System.out.println(
                    "Transfer successful.");
        }
    }
}