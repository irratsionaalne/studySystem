package com.sda.studysystem.services;

import com.sda.studysystem.models.School;
import com.sda.studysystem.models.School;
import com.sda.studysystem.repositories.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepo schoolRepo;

    @Override
    public boolean createSchool(School school) {
        if (school == null) {
            return false;
        }
        school.setSchoolId(school.getSchoolId());
        schoolRepo.save(school);
        return true;
    }

    @Override
    public boolean updateSchool(School school) {
        if (school == null || schoolRepo.existsById(school.getSchoolId())) {
            return false;
        }
        schoolRepo.saveAndFlush(school);
        return true;
    }

    @Override
    public School getById(Long schoolId) {
        return schoolRepo.getOne(schoolId);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepo.findAll();
    }

    @Override
    public boolean deleteSchoolById(Long schoolId) {
        School school = getById(schoolId);
        if (schoolId == null) {
            return false;
        }
        school.setActive(false);
        updateSchool(school);
        return true;
    }

    @Override
    public boolean restoreSchoolById(Long schoolId) {
        School school = getById(schoolId);
        if (schoolId == null) {
            return false;
        }
        school.setActive(true);
        return updateSchool(school);
    }
}
