import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

    private int id;
    private String name;
    private int age;
    private double grade;
    private ArrayList<String> subjects;

    public Student(int id, String name, int age,
                   double grade, ArrayList<String> subjects) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {

        return String.format(
                "%-5d %-20s %-5d %-10.2f %s",
                id, name, age, grade, subjects);
    }
}