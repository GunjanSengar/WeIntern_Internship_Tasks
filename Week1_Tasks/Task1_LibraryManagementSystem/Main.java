
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Book ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter Author Name: ");
                        String author = scanner.nextLine();

                        library.addBook(new Book(id, title, author));
                        break;

                    case 2:

                        library.viewBooks();
                        break;

                    case 3:

                        System.out.println("\nSearch By:");
                        System.out.println("1. Book ID");
                        System.out.println("2. Book Title");
                        System.out.print("Enter Choice: ");

                        int searchChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (searchChoice == 1) {

                            System.out.print("Enter Book ID: ");
                            int searchId = scanner.nextInt();

                            Book book = library.searchById(searchId);

                            if (book != null) {
                                System.out.println(book);
                            } else {
                                System.out.println("Book not found.");
                            }

                        } else if (searchChoice == 2) {

                            System.out.print("Enter Book Title: ");
                            String searchTitle = scanner.nextLine();

                            Book book = library.searchByTitle(searchTitle);

                            if (book != null) {
                                System.out.println(book);
                            } else {
                                System.out.println("Book not found.");
                            }

                        } else {

                            System.out.println("Invalid Search Choice.");
                        }

                        break;

                    case 4:

                        System.out.print("Enter Book ID to Issue: ");
                        int issueId = scanner.nextInt();

                        library.issueBook(issueId);
                        break;

                    case 5:

                        System.out.print("Enter Book ID to Return: ");
                        int returnId = scanner.nextInt();

                        library.returnBook(returnId);
                        break;

                    case 6:

                        System.out.print("Enter Book ID to Remove: ");
                        int removeId = scanner.nextInt();

                        library.removeBook(removeId);
                        break;

                    case 7:

                        System.out.println("Thank You for Using Library Management System!");
                        break;

                    default:

                        System.out.println("Invalid Choice.");
                }

            } catch (Exception e) {

                System.out.println("Invalid Input. Please try again.");
                scanner.nextLine();
                choice = 0;
            }

        } while (choice != 7);

        scanner.close();
    }
}
