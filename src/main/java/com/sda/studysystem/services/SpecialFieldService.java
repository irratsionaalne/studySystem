package com.sda.studysystem.services;

import com.sda.studysystem.models.SpecialField;

import java.util.List;

/**
 * Service to handle SpecialField related operations
 */

public interface SpecialFieldService {


    /**
     * To create a new SpecialField
     *
     * @param specialField SpecialField
     */
    boolean createSpecialField(SpecialField specialField);

    /**
     * To update an existing SpecialField
     *
     * @param specialField
     * @return is it updated
     */
    boolean updateSpecialField(SpecialField specialField);

    /**
     * To get a specialField by id
     *
     * @param specialFieldId
     * @return SpecialField
     */
    SpecialField getById(Long specialFieldId);

    /**
     * To get all the specialFields
     *
     * @return list of all specialFields
     */
    List<SpecialField> getAllSpecialFields();


    /**
     * Delete specialField (change active state) by Id
     *
     * @param specialFieldId
     * @return isActive = false;
     */
    boolean deleteSpecialFieldById(Long specialFieldId);

    /**
     * Restore specialField (change active state) by Id
     * @param specialFieldId
     * @return isActive = true;
     */
    boolean restoreSpecialFieldById(Long specialFieldId);
}
