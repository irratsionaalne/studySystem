package com.sda.studysystem.services;

import com.sda.studysystem.models.Teacher;

import java.util.List;

/**
 * Service to handle Teacher related operations
 */

public interface TeacherService {


    /**
     * To create a new Teacher
     *
     * @param teacher Teacher
     */
    boolean createTeacher(Teacher teacher);

    /**
     * To update an existing Teacher
     *
     * @param teacher
     * @return is it updated
     */
    boolean updateTeacher(Teacher teacher);

    /**
     * To get a teacher by id
     *
     * @param teacherId
     * @return Teacher
     */
    Teacher getById(String teacherId);

    /**
     * To get all the teachers
     *
     * @return list of all teachers
     */
    List<Teacher> getAllTeachers();


    /**
     * Delete teacher by Id
     *
     * @param teacherId
     * @return is it deleted
     */
    boolean deleteTeacherById(String teacherId);
}
