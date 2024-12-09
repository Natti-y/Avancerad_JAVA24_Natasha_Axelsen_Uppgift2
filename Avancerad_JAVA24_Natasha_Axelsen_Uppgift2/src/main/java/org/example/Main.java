package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Get the single instance of StudentManagementSystem (Singleton)
        StudentManagementSystem system = StudentManagementSystem.getInstance();

        // Main menu loop
        while (true) {
            // Display the main menu
            System.out.println("\nStudent Management System");
            System.out.println("1. Add new student");
            System.out.println("2. Search student by ID");
            System.out.println("3. Show all students");
            System.out.println("4. Save students to file");
            System.out.println("5. Load students from file");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            // Read the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            // Handle the user's choice
            switch (choice) {
                case 1:
                    // Add a new student
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    system.addStudent(studentId, name, grade);  // Add the student to the system
                    break;

                case 2:
                    // Search for a student by ID
                    System.out.print("Enter student ID to search: ");
                    String idToSearch = scanner.nextLine();
                    Student student = system.searchStudentById(idToSearch);  // Search for the student
                    if (student != null) {
                        System.out.println(student);  // Print the student's information
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    // Show all students
                    system.showAllStudents();  // Show all students in the system
                    break;

                case 4:
                    // Save all students to file
                    system.saveStudentsToFile();  // Save to file
                    System.out.println("Students saved to file.");
                    break;

                case 5:
                    // Load students from file
                    system.loadStudentsFromFile();  // Load from file
                    System.out.println("Students loaded from file.");
                    break;

                case 6:
                    // Exit the program and save to file
                    system.saveStudentsToFile();  // Save all students before exiting
                    System.out.println("Exiting... Students saved to file.");
                    return;  // Exit the program

                default:
                    // Handle invalid option
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}

