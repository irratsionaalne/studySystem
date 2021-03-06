package com.sda.studysystem.repositories;

import com.sda.studysystem.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Category
 *
 * @author Tanel
 */

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
