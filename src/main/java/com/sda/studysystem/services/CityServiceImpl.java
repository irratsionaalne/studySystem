package com.sda.studysystem.services;

import com.sda.studysystem.models.City;
import com.sda.studysystem.repositories.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepo cityRepo;

    @Override
    public boolean createCity(City city) {
        if (city == null) {
            return false;
        }
        city.setCityId(city.getCityId());
        cityRepo.save(city);
        return true;
    }

    @Override
    public boolean updateCity(City city) {
        if (city == null || cityRepo.existsById(city.getCityId())) {
            return false;
        }
        cityRepo.saveAndFlush(city);
        return true;
    }

    @Override
    public City getById(Long cityId) {
        return cityRepo.getOne(cityId);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepo.findAll();
    }

    @Override
    public boolean deleteCityById(Long cityId) {
        City city = getById(cityId);
        if (cityId == null) {
            return false;
        }
        city.setActive(false);
        updateCity(city);
        return true;
    }

    @Override
    public boolean restoreCityById(Long cityId) {
        City city = getById(cityId);
        if (cityId == null) {
            return false;
        }
        city.setActive(true);
        return updateCity(city);
    }
}
