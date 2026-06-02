import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {

        for (Book b : books) {

            if (b.getBookId() == book.getBookId()) {
                System.out.println("Book ID already exists.");
                return;
            }
        }

        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchById(int id) {

        for (Book book : books) {

            if (book.getBookId() == id) {
                return book;
            }
        }

        return null;
    }

    public Book searchByTitle(String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    public void issueBook(int id) {

        Book book = searchById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book already issued.");
            return;
        }

        book.setAvailable(false);

        System.out.println("Book issued successfully.");
    }

    public void returnBook(int id) {

        Book book = searchById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isAvailable()) {
            System.out.println("Book is already available.");
            return;
        }

        book.setAvailable(true);

        System.out.println("Book returned successfully.");
    }

    public void removeBook(int id) {

        Book book = searchById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        books.remove(book);

        System.out.println("Book removed successfully.");
    }
}