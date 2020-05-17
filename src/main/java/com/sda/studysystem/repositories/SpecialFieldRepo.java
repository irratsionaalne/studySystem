package com.sda.studysystem.repositories;

import com.sda.studysystem.models.SpecialField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for SpecialField
 *
 * @author Tanel
 */

@Repository
public interface SpecialFieldRepo extends JpaRepository<SpecialField, Long> {
}
