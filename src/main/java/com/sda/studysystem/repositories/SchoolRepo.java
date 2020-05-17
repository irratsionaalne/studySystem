package com.sda.studysystem.repositories;

import com.sda.studysystem.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for School
 *
 * @author Tanel
 */

@Repository
public interface SchoolRepo extends JpaRepository<School, Long> {
}
