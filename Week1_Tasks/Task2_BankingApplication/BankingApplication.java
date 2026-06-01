import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class BankingApplication {

    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== BANKING APPLICATION =====");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Print Statement");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            try {

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        openAccount();
                        break;

                    case 2:
                        depositMoney();
                        break;

                    case 3:
                        withdrawMoney();
                        break;

                    case 4:
                        checkBalance();
                        break;

                    case 5:
                        printStatement();
                        break;

                    case 6:
                        System.out.println("Thank You!");
                        break;

                    default:
                        System.out.println("Invalid Choice.");
                }

            } catch (Exception e) {

                System.out.println("Invalid Input.");
                scanner.nextLine();
                choice = 0;
            }

        } while (choice != 6);
    }

    public static void openAccount() {

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Account Number already exists.");
                return;
            }
        }

        System.out.print("Enter Holder Name: ");
        String holderName = scanner.nextLine();

        if (holderName.trim().isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        BankAccount account = new BankAccount(accountNumber, holderName);

        accounts.add(account);

        System.out.println("Account Created Successfully.");
    }

    public static BankAccount findAccount(String accountNumber) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;
    }

    public static void depositMoney() {

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Not Found.");
            return;
        }

        System.out.print("Enter Deposit Amount: ");
        BigDecimal amount = scanner.nextBigDecimal();

        account.deposit(amount);
    }

    public static void withdrawMoney() {

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Not Found.");
            return;
        }

        System.out.print("Enter Withdrawal Amount: ");
        BigDecimal amount = scanner.nextBigDecimal();

        account.withdraw(amount);
    }

    public static void checkBalance() {

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Not Found.");
            return;
        }

        System.out.println("Current Balance: ₹" + account.getBalance());
    }

    public static void printStatement() {

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Not Found.");
            return;
        }

        account.printStatement();
    }
}