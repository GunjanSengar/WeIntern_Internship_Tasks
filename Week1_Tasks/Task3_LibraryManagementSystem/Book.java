public class Book {

    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book ID: " + id +
                ", Title: " + title +
                ", Author: " + author;
    }
}