package org.example;

// Class to represent a student
public class Student {
    private String id;
    private String name;
    private String grade;

    // Constructor for the Student object
    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getter methods to retrieve information about the student
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    // Override toString method to print the student's information
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
}

