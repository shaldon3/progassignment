/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassignment1;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Shaldon
 */
public class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    public void saveStudent(Student student) {
        students.add(student);
    }

    public Student searchStudent(int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null; // Student not found
    }

    public boolean deleteStudent(int studentID) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentID() == studentID) {
                iterator.remove();
                return true; // Student deleted
            }
        }
        return false; // Student not found
    }

    public String studentReport() {
        StringBuilder report = new StringBuilder("Student Report:\n");
        for (Student student : students) {
            report.append("Name: ").append(student.getName()).append(", ID: ").append(student.getStudentID()).append("\n");
        }
        return report.toString();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}

