public class CurrentAccount extends BankAccount {

    public CurrentAccount(
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

        if (amount > balance) {

            System.out.println(
                    "Insufficient funds.");
            return;
        }

        balance -= amount;

        transactions.add(
                new Transaction("Withdraw", amount));

        System.out.println(
                "Withdrawal successful.");
    }
}