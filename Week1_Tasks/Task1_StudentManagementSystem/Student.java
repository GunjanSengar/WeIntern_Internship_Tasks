public class Student {

    private int id;
    private String name;
    private int age;
    private Grade grade;
    private String email;

    public Student(int id, String name, int age, Grade grade, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.email = email;
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

    public Grade getGrade() {
        return grade;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Age: " + age +
                ", Grade: " + grade +
                ", Email: " + email;
    }
}