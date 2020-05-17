package com.sda.studysystem.services;

import com.sda.studysystem.models.Student;

import java.util.List;

public interface StudentService {

    boolean createStudent (Student student);

    boolean updateStudent (Student student);

    Student getById(String studentId);

    List<Student> getAllStudents();

    boolean deleteStudentById(String studentId);
}
