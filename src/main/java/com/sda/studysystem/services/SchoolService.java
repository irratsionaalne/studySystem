package com.sda.studysystem.services;

import com.sda.studysystem.models.School;

import java.util.List;

/**
 * Service to handle School related operations
 */

public interface SchoolService {


    /**
     * To create a new School
     *
     * @param school School
     */
    boolean createSchool(School school);

    /**
     * To update an existing School
     *
     * @param school
     * @return is it updated
     */
    boolean updateSchool(School school);

    /**
     * To get a school by id
     *
     * @param schoolId
     * @return School
     */
    School getById(Long schoolId);

    /**
     * To get all the schools
     *
     * @return list of all schools
     */
    List<School> getAllSchools();


    /**
     * Delete school (change active state) by Id
     *
     * @param schoolId
     * @return isActive = false;
     */
    boolean deleteSchoolById(Long schoolId);

    /**
     * Restore school (change active state) by Id
     * @param schoolId
     * @return isActive = true;
     */
    boolean restoreSchoolById(Long schoolId);
}
