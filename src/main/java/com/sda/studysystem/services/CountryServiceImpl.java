package com.sda.studysystem.services;

import com.sda.studysystem.models.Country;
import com.sda.studysystem.models.Country;
import com.sda.studysystem.repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepo countryRepo;

    @Override
    public boolean createCountry(Country country) {
        if (country == null) {
            return false;
        }
        country.setCountryId(country.getCountryId());
        countryRepo.save(country);
        return true;
    }

    @Override
    public boolean updateCountry(Country country) {
        if (country == null || countryRepo.existsById(country.getCountryId())) {
            return false;
        }
        countryRepo.saveAndFlush(country);
        return true;
    }

    @Override
    public Country getById(Long countryId) {
        return countryRepo.getOne(countryId);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepo.findAll();
    }

    @Override
    public boolean deleteCountryById(Long countryId) {
        Country country = getById(countryId);
        if (countryId == null) {
            return false;
        }
        country.setActive(false);
        updateCountry(country);
        return true;
    }

    @Override
    public boolean restoreCountryById(Long countryId) {
        Country country = getById(countryId);
        if (countryId == null) {
            return false;
        }
        country.setActive(true);
        return updateCountry(country);
    }
}
