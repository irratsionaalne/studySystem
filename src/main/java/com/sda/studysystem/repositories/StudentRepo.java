package com.sda.studysystem.repositories;

import com.sda.studysystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Student
 *
 * @author Tanel
 */

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
