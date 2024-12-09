package org.example;import java.io.*;
import java.util.HashMap;

public class StudentManagementSystem {
    private static StudentManagementSystem instance;  // Singleton instance
    private HashMap<String, Student> students = new HashMap<>();  // Store students in a HashMap
    private final String filePath = "students.txt";  // File path for reading and writing to file

    // Private constructor for Singleton
    private StudentManagementSystem() {
    }

    // Get the single instance of the system
    public static StudentManagementSystem getInstance() {
        if (instance == null) {
            instance = new StudentManagementSystem();  // Create the instance if it doesn't exist
        }
        return instance;
    }

    // Add a student to the system
    public void addStudent(String id, String name, String grade) {
        students.put(id, new Student(id, name, grade));  // Add student to HashMap
    }

    // Search for a student by ID
    public Student searchStudentById(String id) {
        return students.get(id);  // Return the student based on the ID
    }

    // Show all students stored in the system
    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students.values()) {
                System.out.println(student);  // Print each student's information
            }
        }
    }

    // Save all students to file
    public void saveStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : students.values()) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getGrade());
                writer.newLine();  // Write each student on a new line
            }
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Load students from file and add them to the system
    public void loadStudentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");  // Split each line into data
                if (data.length == 3) {
                    addStudent(data[0], data[1], data[2]);  // Add the student to the system
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }
}
