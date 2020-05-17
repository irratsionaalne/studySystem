package com.sda.studysystem.services;

import com.sda.studysystem.models.Country;

import java.util.List;

/**
 * Service to handle Country related operations
 */

public interface CountryService {


    /**
     * To create a new Country
     *
     * @param country Country
     */
    boolean createCountry(Country country);

    /**
     * To update an existing Country
     *
     * @param country
     * @return is it updated
     */
    boolean updateCountry(Country country);

    /**
     * To get a country by id
     *
     * @param countryId
     * @return Country
     */
    Country getById(Long countryId);

    /**
     * To get all the countries
     *
     * @return list of all countries
     */
    List<Country> getAllCountries();


    /**
     * Delete country (change active state) by Id
     *
     * @param countryId
     * @return isActive = false;
     */
    boolean deleteCountryById(Long countryId);

    /**
     * Restore country (change active state) by Id
     * @param countryId
     * @return isActive = true;
     */
    boolean restoreCountryById(Long countryId);
}
