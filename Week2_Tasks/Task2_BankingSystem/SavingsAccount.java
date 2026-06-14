public class SavingsAccount extends BankAccount {

    private static final double MIN_BALANCE = 1000;

    public SavingsAccount(
            int accountNumber,
            String holderName,
            double balance) {

        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {

            System.out.println("Invalid amount.");
            return;
        }

        if (balance - amount < MIN_BALANCE) {

            System.out.println(
                    "Minimum balance rule violated.");
            return;
        }

        balance -= amount;

        transactions.add(
                new Transaction("Withdraw", amount));

        System.out.println(
                "Withdrawal successful.");
    }
}