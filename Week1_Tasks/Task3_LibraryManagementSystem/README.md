# Library Management System

## Project Overview

This is a console-based Library Management System developed as part of the WeIntern Java Developer Internship.

The application allows users to manage books in a library using Java Collections and Exception Handling. Users can add books, view available books, search for books by ID, and remove books from the library.

The project demonstrates:
- Object-Oriented Programming (OOP)
- Java Collections Framework (ArrayList)
- Custom Exception Handling
- Menu-Driven Console Application
- Input Validation

---

# Features

✅ Add New Book  
✅ View All Books  
✅ Search Book by ID  
✅ Remove Book  
✅ Custom Exception Handling  
✅ ArrayList Collection Usage  
✅ Menu-Driven Console Application  
✅ Clean and Modular Code Structure  

---

# Technologies Used

- Java
- ArrayList
- OOP (Object-Oriented Programming)
- Exception Handling
- VS Code
- Git & GitHub

---

# Project Structure

```text
Task3_LibraryManagementSystem/
│
├── images/
│   ├── mainmenu.png
│   ├── add-book.png
│   ├── view-books.png
│   └── exception.png
│
├── Book.java
├── BookNotFoundException.java
├── LibraryManagementSystem.java
└── README.md
```

---

# How to Run

## Step 1: Compile the Java Files

```bash
javac *.java
```

## Step 2: Run the Application

```bash
java LibraryManagementSystem
```

---

# Sample Output

```text
=================================
     LIBRARY MANAGEMENT SYSTEM
=================================
1. Add Book
2. View All Books
3. Search Book
4. Remove Book
5. Exit

Enter Choice:
```

---

# Application Menu

![Application Menu](images/mainmenu.png)

---

# Add Book

![Add Book](images/add-book.png)

---

# View Books

![View Books](images/view-books.png)

---

# Custom Exception Handling

Example when searching for a book that does not exist:

```text
Book with ID 999 not found.
```

![Exception Handling](images/exception.png)

---

# Test Scenarios

### Test Case 1: Add and View Books

**Input:**

```text
1
101
Java Programming
James Gosling
```

**Expected Result:**

```text
Book Added Successfully.
```

---

### Test Case 2: Search Existing Book

**Input:**

```text
3
101
```

**Expected Result:**

```text
Book ID: 101, Title: Java Programming, Author: James Gosling
```

---

### Test Case 3: Search Non-Existing Book

**Input:**

```text
3
999
```

**Expected Result:**

```text
Book with ID 999 not found.
```

---

# Learning Outcomes

Through this project, I learned:

- Java Collections Framework
- Custom Exception Creation
- Exception Handling Best Practices
- CRUD Operations using ArrayList
- Menu-Driven Application Development
- Git & GitHub Workflow

---

# Author

Gunjan