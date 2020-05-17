package com.sda.studysystem.services;

import com.sda.studysystem.models.Student;
import com.sda.studysystem.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public boolean createStudent(Student student) {
        if (student == null) {
            return false;
        }
        student.setStudentId(student.getStudentId());
        studentRepo.save(student);
        return true;
    }

    @Override
    public boolean updateStudent(Student student) {
        if (student == null || studentRepo.existsById(student.getStudentId())) {
            return false;
        }
        studentRepo.saveAndFlush(student);
        return true;
    }

    @Override
    public Student getById(Long studentId) {
        return studentRepo.getOne(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public boolean deleteStudentById(Long studentId) {
        Student student = getById(studentId);
        if (studentId == null) {
            return false;
        }
        student.setActive(false);
        updateStudent(student);
        return true;
    }

    @Override
    public boolean restoreStudentById(Long studentId) {
        Student student = getById(studentId);
        if (studentId == null) {
            return false;
        }
        student.setActive(true);
        return updateStudent(student);
    }
}
