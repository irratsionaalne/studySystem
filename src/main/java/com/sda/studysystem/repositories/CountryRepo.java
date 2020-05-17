package com.sda.studysystem.repositories;

import com.sda.studysystem.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Country
 *
 * @author Tanel
 */

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
}
