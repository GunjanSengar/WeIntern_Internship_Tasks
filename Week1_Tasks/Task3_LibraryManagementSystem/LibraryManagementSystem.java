import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    removeBook();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
    }

    public static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book Added Successfully.");
    }

    public static void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No Books Available.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void searchBook() {

        try {

            System.out.print("Enter Book ID: ");
            int id = scanner.nextInt();

            Book book = findBook(id);

            System.out.println(book);

        } catch (BookNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    public static void removeBook() {

        try {

            System.out.print("Enter Book ID: ");
            int id = scanner.nextInt();

            Book book = findBook(id);

            books.remove(book);

            System.out.println("Book Removed Successfully.");

        } catch (BookNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    public static Book findBook(int id) throws BookNotFoundException {

        for (Book book : books) {

            if (book.getId() == id) {
                return book;
            }
        }

        throw new BookNotFoundException(
                "Book with ID " + id + " not found.");
    }
}