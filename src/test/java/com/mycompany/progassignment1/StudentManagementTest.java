/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progassignment1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentManagementTest {
    private StudentManagement studentManagement;

    @BeforeEach
    public void setUp() {
        // Create a new StudentManagement object before each test
        studentManagement = new StudentManagement();
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student(1, "John Doe", 20, "john@example.com", "Math");
        studentManagement.saveStudent(student);
        assertEquals(student, studentManagement.searchStudent(1));
    }

    @Test
    public void testSearchStudent() {
        Student student = new Student(1, "John Doe", 20, "john@example.com", "Math");
        studentManagement.saveStudent(student);
        assertEquals(student, studentManagement.searchStudent(1));
    }

    @Test
    public void testSearchStudentNotFound() {
        assertNull(studentManagement.searchStudent(1)); // Student not found
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student(1, "John Doe", 20, "john@example.com", "Math");
        studentManagement.saveStudent(student);
        assertTrue(studentManagement.deleteStudent(1)); // Student deleted
        assertNull(studentManagement.searchStudent(1)); // Student not found after deletion
    }

    @Test
    public void testDeleteStudentNotFound() {
        assertFalse(studentManagement.deleteStudent(1)); // Student not found
    }

    @Test
    public void testStudentReport() {
        Student student1 = new Student(1, "John Doe", 20, "john@example.com", "Math");
        Student student2 = new Student(2, "Jane Doe", 21, "jane@example.com", "Physics");
        studentManagement.saveStudent(student1);
        studentManagement.saveStudent(student2);
        String expectedReport = "Student Report:\n" +
                "Name: John Doe, ID: 1\n" +
                "Name: Jane Doe, ID: 2\n";
        assertEquals(expectedReport, studentManagement.studentReport());
    }
}