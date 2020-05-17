package com.sda.studysystem.services;

import com.sda.studysystem.models.County;
import com.sda.studysystem.models.County;
import com.sda.studysystem.repositories.CountyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyServiceImpl implements CountyService {

    @Autowired
    private CountyRepo countyRepo;

    @Override
    public boolean createCounty(County county) {
        if (county == null) {
            return false;
        }
        county.setCountyId(county.getCountyId());
        countyRepo.save(county);
        return true;
    }

    @Override
    public boolean updateCounty(County county) {
        if (county == null || countyRepo.existsById(county.getCountyId())) {
            return false;
        }
        countyRepo.saveAndFlush(county);
        return true;
    }

    @Override
    public County getById(Long countyId) {
        return countyRepo.getOne(countyId);
    }

    @Override
    public List<County> getAllCounties() {
        return countyRepo.findAll();
    }

    @Override
    public boolean deleteCountyById(Long countyId) {
        County county = getById(countyId);
        if (countyId == null) {
            return false;
        }
        county.setActive(false);
        updateCounty(county);
        return true;
    }

    @Override
    public boolean restoreCountyById(Long countyId) {
        County county = getById(countyId);
        if (countyId == null) {
            return false;
        }
        county.setActive(true);
        return updateCounty(county);
    }
}
