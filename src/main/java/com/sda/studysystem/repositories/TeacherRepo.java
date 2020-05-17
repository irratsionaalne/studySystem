package com.sda.studysystem.repositories;

import com.sda.studysystem.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Teacher
 *
 * @author Tanel
 */

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {
}
