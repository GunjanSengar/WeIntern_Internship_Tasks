import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentManager manager =
                new StudentManager();

        manager.loadFromFile();

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student By ID");
            System.out.println("4. Search Student By Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Calculate Average Grade");
            System.out.println("8. Save Data");
            System.out.println("9. Exit");

            System.out.print("Enter Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Age: ");
                    int age = scanner.nextInt();

                    System.out.print("Grade: ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine();

                    ArrayList<String> subjects =
                            new ArrayList<>();

                    System.out.print(
                            "Enter Subjects (comma separated): ");

                    String[] sub =
                            scanner.nextLine().split(",");

                    for (String s : sub) {

                        subjects.add(s.trim());
                    }

                    manager.addStudent(
                            new Student(
                                    id,
                                    name,
                                    age,
                                    grade,
                                    subjects));

                    break;

                case 2:

                    manager.displayAll();
                    break;

                case 3:

                    System.out.print(
                            "Enter ID: ");

                    Student byId =
                            manager.searchById(
                                    scanner.nextInt());

                    System.out.println(
                            byId != null
                                    ? byId
                                    : "Student not found");

                    break;

                case 4:

                    scanner.nextLine();

                    System.out.print(
                            "Enter Name: ");

                    Student byName =
                            manager.searchByName(
                                    scanner.nextLine());

                    System.out.println(
                            byName != null
                                    ? byName
                                    : "Student not found");

                    break;

                case 5:

                    System.out.print(
                            "Student ID: ");

                    int updateId =
                            scanner.nextInt();

                    System.out.print(
                            "New Grade: ");

                    double newGrade =
                            scanner.nextDouble();

                    scanner.nextLine();

                    ArrayList<String> newSubjects =
                            new ArrayList<>();

                    System.out.print(
                            "New Subjects (comma separated): ");

                    String[] updated =
                            scanner.nextLine().split(",");

                    for (String s : updated) {

                        newSubjects.add(s.trim());
                    }

                    manager.updateStudent(
                            updateId,
                            newGrade,
                            newSubjects);

                    break;

                case 6:

                    System.out.print(
                            "Student ID: ");

                    manager.deleteStudent(
                            scanner.nextInt());

                    break;

                case 7:

                    manager.calculateAverage();
                    break;

                case 8:

                    manager.saveToFile();

                    System.out.println(
                            "Data saved successfully.");

                    break;

                case 9:

                    manager.saveToFile();

                    System.out.println(
                            "Exiting...");
                    break;

                default:

                    System.out.println(
                            "Invalid choice.");
            }

        } while (choice != 9);

        scanner.close();
    }
}