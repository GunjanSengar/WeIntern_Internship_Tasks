import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingApp {

    private BankAccount account;
    private Scanner scanner;

    public BankingApp() {
        account = new BankAccount();
        scanner = new Scanner(System.in);
    }

    public void start() {

        int choice = 0;

        do {

            System.out.println("\n=================================");
            System.out.println("      BANKING APPLICATION");
            System.out.println("=================================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {

                choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        deposit();
                        break;

                    case 2:
                        withdraw();
                        break;

                    case 3:
                        checkBalance();
                        break;

                    case 4:
                        System.out.println("Thank You!");
                        break;

                    default:
                        System.out.println("Invalid Choice.");
                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine();
            }

        } while (choice != 4);
    }

    private void deposit() {

        try {

            System.out.print("Enter Deposit Amount: ");
            double amount = scanner.nextDouble();

            account.deposit(amount);

        } catch (InputMismatchException e) {

            System.out.println("Invalid amount entered.");
            scanner.nextLine();
        }
    }

    private void withdraw() {

        try {

            System.out.print("Enter Withdrawal Amount: ");
            double amount = scanner.nextDouble();

            account.withdraw(amount);

        } catch (InputMismatchException e) {

            System.out.println("Invalid amount entered.");
            scanner.nextLine();
        }
    }

    private void checkBalance() {

        System.out.printf("Current Balance: %.2f%n",
                account.getBalance());
    }
}