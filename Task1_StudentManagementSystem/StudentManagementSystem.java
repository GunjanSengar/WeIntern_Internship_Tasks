import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        addStudent();
                        break;

                    case 2:
                        viewStudents();
                        break;

                    case 3:
                        searchStudent();
                        break;

                    case 4:
                        updateStudent();
                        break;

                    case 5:
                        deleteStudent();
                        break;

                    case 6:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {

                System.out.println("Invalid input!");
                scanner.nextLine();
                choice = 0;
            }

        } while (choice != 6);
    }

    // Add Student
    public static void addStudent() {

        try {

            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            // Duplicate ID Check
            for (Student s : students) {
                if (s.getId() == id) {
                    System.out.println("Student ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            if (name.trim().isEmpty()) {
                System.out.println("Name cannot be empty!");
                return;
            }

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            if (age < 5 || age > 100) {
                System.out.println("Invalid age!");
                return;
            }

            System.out.print("Enter Grade (A/B/C/D/F): ");
            Grade grade = Grade.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            if (!email.contains("@")) {
                System.out.println("Invalid email!");
                return;
            }

            Student student = new Student(id, name, age, grade, email);

            students.add(student);

            System.out.println("Student added successfully!");

        } catch (IllegalArgumentException e) {

            System.out.println("Invalid grade entered!");

        } catch (Exception e) {

            System.out.println("Something went wrong!");
            scanner.nextLine();
        }
    }

    // View All Students
    public static void viewStudents() {

        if (students.isEmpty()) {

            System.out.println("No students found!");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Search Student
    public static void searchStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        for (Student s : students) {

            if (s.getId() == id) {

                System.out.println("Student Found:");
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Update Student
    public static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student s : students) {

            if (s.getId() == id) {

                System.out.print("Enter New Name: ");
                String name = scanner.nextLine();

                if (!name.trim().isEmpty()) {
                    s.setName(name);
                }

                System.out.print("Enter New Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                if (age >= 5 && age <= 100) {
                    s.setAge(age);
                }

                System.out.print("Enter New Grade (A/B/C/D/F): ");
                Grade grade = Grade.valueOf(scanner.nextLine().toUpperCase());

                s.setGrade(grade);

                System.out.print("Enter New Email: ");
                String email = scanner.nextLine();

                if (email.contains("@")) {
                    s.setEmail(email);
                }

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Delete Student
    public static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        for (Student s : students) {

            if (s.getId() == id) {

                students.remove(s);

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }
}