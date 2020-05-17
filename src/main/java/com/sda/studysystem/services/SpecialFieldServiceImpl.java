package com.sda.studysystem.services;

import com.sda.studysystem.models.SpecialField;
import com.sda.studysystem.repositories.SpecialFieldRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialFieldServiceImpl implements SpecialFieldService {

    @Autowired
    private SpecialFieldRepo specialFieldRepo;

    @Override
    public boolean createSpecialField(SpecialField specialField) {
        if (specialField == null) {
            return false;
        }
        specialField.setSpecialFieldId(specialField.getSpecialFieldId());
        specialFieldRepo.save(specialField);
        return true;
    }

    @Override
    public boolean updateSpecialField(SpecialField specialField) {
        if (specialField == null || specialFieldRepo.existsById(specialField.getSpecialFieldId())) {
            return false;
        }
        specialFieldRepo.saveAndFlush(specialField);
        return true;
    }

    @Override
    public SpecialField getById(Long specialFieldId) {
        return specialFieldRepo.getOne(specialFieldId);
    }

    @Override
    public List<SpecialField> getAllSpecialFields() {
        return specialFieldRepo.findAll();
    }

    @Override
    public boolean deleteSpecialFieldById(Long specialFieldId) {
        SpecialField specialField = getById(specialFieldId);
        if (specialFieldId == null) {
            return false;
        }
        specialField.setActive(false);
        updateSpecialField(specialField);
        return true;
    }

    @Override
    public boolean restoreSpecialFieldById(Long specialFieldId) {
        SpecialField specialField = getById(specialFieldId);
        if (specialFieldId == null) {
            return false;
        }
        specialField.setActive(true);
        return updateSpecialField(specialField);
    }
}
