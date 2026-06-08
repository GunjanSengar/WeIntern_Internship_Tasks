import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CollectionManager manager = new CollectionManager();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("   JAVA COLLECTIONS CHALLENGE");
            System.out.println("=================================");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Add Student");
            System.out.println("4. Display Students");
            System.out.println("5. Add Customer to Queue");
            System.out.println("6. Serve Customer");
            System.out.println("7. View Next Customer");
            System.out.println("8. Display Queue");
            System.out.println("9. Exit");
            System.out.print("Enter Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book Name: ");
                    manager.addBook(scanner.nextLine());
                    break;

                case 2:
                    manager.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    manager.addStudent(id, name);
                    break;

                case 4:
                    manager.displayStudents();
                    break;

                case 5:
                    System.out.print("Enter Customer Name: ");
                    manager.addCustomer(scanner.nextLine());
                    break;

                case 6:
                    manager.serveCustomer();
                    break;

                case 7:
                    manager.peekCustomer();
                    break;

                case 8:
                    manager.displayQueue();
                    break;

                case 9:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 9);

        scanner.close();
    }
}