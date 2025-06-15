// StudentManager.java
package org.ahmet.classes.service;

import org.ahmet.classes.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentService{
    private List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    public List<Student> filterByGrade(double minGrade) {
        return students.stream()
                .filter(student -> student.getGrade() >= minGrade)
                .collect(Collectors.toList());
    }

    public double calculateAverageGrade() {
        return students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    public List<String> getStudentNames() {
        return students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
    }
}