package com.sda.studysystem.repositories;

import com.sda.studysystem.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for City
 *
 * @author Tanel
 */

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
}
