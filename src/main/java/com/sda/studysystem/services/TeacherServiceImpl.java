package com.sda.studysystem.services;

import com.sda.studysystem.models.Teacher;
import com.sda.studysystem.repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of TeacherService
 *
 * @author Tanel
 */

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public boolean createTeacher(Teacher teacher) {
        if (teacher == null) {
            return false;
        }

        teacher.setTeacherId(teacher.getTeacherId());
        teacherRepo.save(teacher);
        return true;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        if (teacher == null || teacherRepo.existsById(teacher.getTeacherId())) {
            return false;
        }
        teacherRepo.saveAndFlush(teacher);
        return true;
    }

    @Override
    public Teacher getById(Long teacherId) {
        return teacherRepo.getOne(teacherId);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public boolean deleteTeacherById(Long teacherId) {
        Teacher teacher = getById(teacherId);
        if (teacherId == null) {
            return false;
        }
        teacher.setActive(false);
        updateTeacher(teacher);
        return true;
    }

    @Override
    public boolean restoreTeacherById(Long teacherId) {
        Teacher teacher = getById(teacherId);
        if (teacherId == null) {
            return false;
        }
        teacher.setActive(true);
        return updateTeacher(teacher);
    }

}
