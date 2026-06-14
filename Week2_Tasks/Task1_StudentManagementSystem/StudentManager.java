import java.io.*;
import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students =
            new ArrayList<>();

    private final String FILE_NAME =
            "students.txt";

    public void addStudent(Student student) {

        for (Student s : students) {

            if (s.getId() == student.getId()) {

                System.out.println(
                        "Student ID already exists.");
                return;
            }
        }

        students.add(student);

        System.out.println(
                "Student added successfully.");
    }

    public void displayAll() {

        if (students.isEmpty()) {

            System.out.println(
                    "No students found.");
            return;
        }

        System.out.printf(
                "%-5s %-20s %-5s %-10s %s%n",
                "ID",
                "Name",
                "Age",
                "Grade",
                "Subjects");

        for (Student student : students) {

            System.out.println(student);
        }
    }

    public Student searchById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                return student;
            }
        }

        return null;
    }

    public Student searchByName(String name) {

        for (Student student : students) {

            if (student.getName()
                    .equalsIgnoreCase(name)) {

                return student;
            }
        }

        return null;
    }

    public void updateStudent(
            int id,
            double newGrade,
            ArrayList<String> subjects) {

        Student student = searchById(id);

        if (student == null) {

            System.out.println(
                    "Student not found.");
            return;
        }

        student.setGrade(newGrade);
        student.setSubjects(subjects);

        System.out.println(
                "Student updated successfully.");
    }

    public void deleteStudent(int id) {

        Student student = searchById(id);

        if (student == null) {

            System.out.println(
                    "Student not found.");
            return;
        }

        students.remove(student);

        System.out.println(
                "Student deleted successfully.");
    }

    public void calculateAverage() {

        if (students.isEmpty()) {

            System.out.println(
                    "No students available.");
            return;
        }

        double total = 0;

        for (Student student : students) {

            total += student.getGrade();
        }

        System.out.printf(
                "Class Average Grade: %.2f%n",
                total / students.size());
    }

    public void saveToFile() {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            out.writeObject(students);

        } catch (Exception e) {

            System.out.println(
                    "Error saving data.");
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream(FILE_NAME))) {

            students =
                    (ArrayList<Student>) in.readObject();

        } catch (Exception e) {

            System.out.println(
                    "Error loading data.");
        }
    }
}