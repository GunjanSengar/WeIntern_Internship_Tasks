import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("    STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

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
                        System.out.println("Thank You!");
                        break;

                    default:
                        System.out.println("Invalid Choice.");
                }

            } catch (Exception e) {

                System.out.println("Invalid Input!");
                scanner.nextLine();
                choice = 0;
            }

        } while (choice != 6);
    }

    public static void addStudent() {

        try {

            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            for (Student student : students) {
                if (student.getId() == id) {
                    System.out.println("Student ID already exists.");
                    return;
                }
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            if (name.trim().isEmpty()) {
                System.out.println("Name cannot be empty.");
                return;
            }

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            if (age < 5 || age > 100) {
                System.out.println("Invalid age.");
                return;
            }

            System.out.print("Enter Grade (A/B/C/D/F): ");
            Grade grade = Grade.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            Student student = new Student(id, name, age, grade, email);

            students.add(student);

            System.out.println("Student Added Successfully.");

        } catch (Exception e) {

            System.out.println("Invalid Input.");
        }
    }

    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void searchStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        for (Student student : students) {

            if (student.getId() == id) {
                System.out.println(student);
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    public static void updateStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.print("Enter New Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter New Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter New Grade (A/B/C/D/F): ");
                Grade grade = Grade.valueOf(scanner.nextLine().toUpperCase());

                System.out.print("Enter New Email: ");
                String email = scanner.nextLine();

                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);
                student.setEmail(email);

                System.out.println("Student Updated Successfully.");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    public static void deleteStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        for (Student student : students) {

            if (student.getId() == id) {

                students.remove(student);

                System.out.println("Student Deleted Successfully.");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }
}