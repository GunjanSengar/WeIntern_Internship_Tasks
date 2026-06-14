import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("        BANKING SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer Money");
            System.out.println("6. Check Balance");
            System.out.println("7. Account Statement");
            System.out.println("8. Exit");
            System.out.print("Enter Choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    scanner.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String savingsName = scanner.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double savingsBalance = scanner.nextDouble();

                    bank.createSavingsAccount(
                            savingsName,
                            savingsBalance);

                    break;

                case 2:

                    scanner.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String currentName = scanner.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double currentBalance = scanner.nextDouble();

                    bank.createCurrentAccount(
                            currentName,
                            currentBalance);

                    break;

                case 3:

                    System.out.print("Enter Account Number: ");
                    int depositAcc = scanner.nextInt();

                    BankAccount depositAccount =
                            bank.findAccount(depositAcc);

                    if (depositAccount == null) {

                        System.out.println(
                                "Account not found.");
                        break;
                    }

                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount =
                            scanner.nextDouble();

                    depositAccount.deposit(
                            depositAmount);

                    break;

                case 4:

                    System.out.print("Enter Account Number: ");
                    int withdrawAcc =
                            scanner.nextInt();

                    BankAccount withdrawAccount =
                            bank.findAccount(withdrawAcc);

                    if (withdrawAccount == null) {

                        System.out.println(
                                "Account not found.");
                        break;
                    }

                    System.out.print(
                            "Enter Withdrawal Amount: ");

                    double withdrawAmount =
                            scanner.nextDouble();

                    withdrawAccount.withdraw(
                            withdrawAmount);

                    break;

                case 5:

                    System.out.print(
                            "From Account Number: ");

                    int from =
                            scanner.nextInt();

                    System.out.print(
                            "To Account Number: ");

                    int to =
                            scanner.nextInt();

                    System.out.print(
                            "Amount: ");

                    double transferAmount =
                            scanner.nextDouble();

                    bank.transfer(
                            from,
                            to,
                            transferAmount);

                    break;

                case 6:

                    System.out.print(
                            "Enter Account Number: ");

                    int balanceAcc =
                            scanner.nextInt();

                    BankAccount balanceAccount =
                            bank.findAccount(
                                    balanceAcc);

                    if (balanceAccount == null) {

                        System.out.println(
                                "Account not found.");
                    } else {

                        System.out.println(
                                "Current Balance: ₹"
                                        + balanceAccount.getBalance());
                    }

                    break;

                case 7:

                    System.out.print(
                            "Enter Account Number: ");

                    int statementAcc =
                            scanner.nextInt();

                    BankAccount statementAccount =
                            bank.findAccount(
                                    statementAcc);

                    if (statementAccount == null) {

                        System.out.println(
                                "Account not found.");
                    } else {

                        statementAccount.printStatement();
                    }

                    break;

                case 8:

                    System.out.println(
                            "Thank you for using Banking System.");
                    break;

                default:

                    System.out.println(
                            "Invalid Choice.");
            }

        } while (choice != 8);

        scanner.close();
    }
}