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
        if(student == null) {
            return false;
        }
        student.setStudentId(getNewStudentId());
        studentRepo.save(student);
        return true;
    }

    @Override
    public boolean updateStudent(Student student) {
        if(student == null || studentRepo.existsById(student.getStudentId())){
            return false;
        }
        studentRepo.saveAndFlush(student);
        return true;
    }

    @Override
    public Student getById(String studentId) {
        return studentRepo.getOne(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public boolean deleteStudentById(String studentId) {
        if(studentId == null || studentRepo.existsById(studentId)){
            return false;
        }
        studentRepo.deleteById(studentId);
        return true;
    }

    private String getNewStudentId(){
        return null;
    }
}
