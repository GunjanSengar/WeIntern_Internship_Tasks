import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CollectionManager {

    // ArrayList Challenge
    private ArrayList<String> books = new ArrayList<>();

    // HashMap Challenge
    private HashMap<Integer, String> students = new HashMap<>();

    // Queue Challenge
    private Queue<String> customers = new LinkedList<>();

    // ArrayList Operations

    public void addBook(String book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(String book) {
        if (books.remove(book)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void updateBook(String oldBook, String newBook) {

        int index = books.indexOf(oldBook);

        if (index != -1) {
            books.set(index, newBook);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void searchBook(String book) {

        if (books.contains(book)) {
            System.out.println("Book found.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void displayBooks() {

        System.out.println("\nBooks List:");

        for (String book : books) {
            System.out.println(book);
        }
    }

    // HashMap Operations

    public void addStudent(int id, String name) {

        students.put(id, name);

        System.out.println("Student added successfully.");
    }

    public void getStudent(int id) {

        if (students.containsKey(id)) {
            System.out.println("Student: " + students.get(id));
        } else {
            System.out.println("Student not found.");
        }
    }

    public void updateStudent(int id, String name) {

        if (students.containsKey(id)) {

            students.put(id, name);

            System.out.println("Student updated successfully.");

        } else {

            System.out.println("Student not found.");
        }
    }

    public void displayStudents() {

        System.out.println("\nStudents:");

        for (Map.Entry<Integer, String> entry : students.entrySet()) {

            System.out.println(
                    entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Queue Operations

    public void addCustomer(String customer) {

        customers.add(customer);

        System.out.println("Customer added to queue.");
    }

    public void serveCustomer() {

        if (customers.isEmpty()) {

            System.out.println("Queue is empty.");
            return;
        }

        System.out.println(
                "Serving: " + customers.poll());
    }

    public void peekCustomer() {

        if (customers.isEmpty()) {

            System.out.println("Queue is empty.");
            return;
        }

        System.out.println(
                "Next Customer: " + customers.peek());
    }

    public void displayQueue() {

        System.out.println("\nQueue:");

        for (String customer : customers) {

            System.out.println(customer);
        }
    }
}