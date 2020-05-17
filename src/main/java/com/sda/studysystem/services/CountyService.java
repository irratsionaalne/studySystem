package com.sda.studysystem.services;

import com.sda.studysystem.models.County;

import java.util.List;

/**
 * Service to handle County related operations
 */

public interface CountyService {


    /**
     * To create a new County
     *
     * @param county County
     */
    boolean createCounty(County county);

    /**
     * To update an existing County
     *
     * @param county
     * @return is it updated
     */
    boolean updateCounty(County county);

    /**
     * To get a county by id
     *
     * @param countyId
     * @return County
     */
    County getById(Long countyId);

    /**
     * To get all the counties
     *
     * @return list of all counties
     */
    List<County> getAllCounties();


    /**
     * Delete county (change active state) by Id
     *
     * @param countyId
     * @return isActive = false;
     */
    boolean deleteCountyById(Long countyId);

    /**
     * Restore county (change active state) by Id
     * @param countyId
     * @return isActive = true;
     */
    boolean restoreCountyById(Long countyId);
}
