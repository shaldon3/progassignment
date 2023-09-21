/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progassignment1;
import javax.swing.JOptionPane;
/**
 *
 * @author Shaldon
 */
public class ProgAssignment1 {

    public static void main(String[] args) {
       StudentManagement studentManagement = new StudentManagement();

        while (true) {
            String menu = "Menu:\n" +
                          "1. Capture a new student\n" +
                          "2. Search for a student\n" +
                          "3. Delete a student\n" +
                          "4. View student report\n" +
                          "5. Exit";

            int choice = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (choice) {
                case 1:
                    int studentID = Integer.parseInt(JOptionPane.showInputDialog("Enter student ID:"));
                    String name = JOptionPane.showInputDialog("Enter student name:");
                    int age;
                    do {
                        age = Integer.parseInt(JOptionPane.showInputDialog("Enter student age (must be 16 or higher):"));
                        if (age < 16) {
                            JOptionPane.showMessageDialog(null, "Invalid age. Please enter an age of 16 or higher.");
                        }
                    } while (age < 16);

                    String email = JOptionPane.showInputDialog("Enter student email:");
                    String course = JOptionPane.showInputDialog("Enter student course:");

                    Student newStudent = new Student(studentID, name, age, email, course);
                    studentManagement.saveStudent(newStudent);
                    JOptionPane.showMessageDialog(null, "Student saved successfully.");
                    break;

                case 2:
                    int searchID = Integer.parseInt(JOptionPane.showInputDialog("Enter student ID to search:"));
                    Student foundStudent = studentManagement.searchStudent(searchID);
                    if (foundStudent != null) {
                        JOptionPane.showMessageDialog(null, "Student found:\n" +
                                "Name: " + foundStudent.getName() + "\n" +
                                "Age: " + foundStudent.getAge() + "\n" +
                                "Email: " + foundStudent.getEmail() + "\n" +
                                "Course: " + foundStudent.getCourse());
                    } else {
                        JOptionPane.showMessageDialog(null, "Student not found.");
                    }
                    break;

                case 3:
                    int deleteID = Integer.parseInt(JOptionPane.showInputDialog("Enter student ID to delete:"));
                    boolean deleted = studentManagement.deleteStudent(deleteID);
                    if (deleted) {
                        JOptionPane.showMessageDialog(null, "Student deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Student not found.");
                    }
                    break;

                case 4:
                    String report = studentManagement.studentReport();
                    JOptionPane.showMessageDialog(null, report);
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Exiting the application.");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
    

