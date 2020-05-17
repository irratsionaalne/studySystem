package com.sda.studysystem.services;

import com.sda.studysystem.models.City;

import java.util.List;

/**
 * Service to handle City related operations
 */

public interface CityService {


    /**
     * To create a new City
     *
     * @param city
     */
    boolean createCity(City city);

    /**
     * To update an existing City
     *
     * @param city
     * @return is it updated
     */
    boolean updateCity(City city);

    /**
     * To get a City by id
     *
     * @param cityId
     * @return City
     */
    City getById(Long cityId);

    /**
     * To get all the Citys
     *
     * @return list of all Cities
     */
    List<City> getAllCities();


    /**
     * Delete City (change active state) by Id
     *
     * @param cityId
     * @return isActive = false;
     */
    boolean deleteCityById(Long cityId);

    /**
     * Restore City (change active state) by Id
     * @param cityId
     * @return isActive = true;
     */
    boolean restoreCityById(Long cityId);
}
