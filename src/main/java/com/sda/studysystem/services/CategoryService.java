package com.sda.studysystem.services;

import com.sda.studysystem.models.Category;
import com.sda.studysystem.models.Teacher;

import java.util.List;

/**
 * Service to handle Category related operations
 */

public interface CategoryService {


    /**
     * To create a new Category
     *
     * @param category Category
     */
    boolean createCategory(Category category);

    /**
     * To update an existing Category
     *
     * @param category
     * @return is it updated
     */
    boolean updateCategory(Category category);

    /**
     * To get a teacher by id
     *
     * @param categoryId
     * @return Category
     */
    Category getById(Long categoryId);

    /**
     * To get all the categories
     *
     * @return list of all categories
     */
    List<Category> getAllCategories();


    /**
     * Delete category (change active state) by Id
     *
     * @param categoryId
     */
    boolean deleteCategoryById(Long categoryId);

    /**
     * Restore category by Id

     * @return isActive = true;
     */
    boolean restoreCategoryById(Long categoryId);
}
