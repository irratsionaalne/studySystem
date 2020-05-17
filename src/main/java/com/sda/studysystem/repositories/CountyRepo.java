package com.sda.studysystem.repositories;

import com.sda.studysystem.models.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for County
 *
 * @author Tanel
 */

@Repository
public interface CountyRepo extends JpaRepository<County, Long> {
}
