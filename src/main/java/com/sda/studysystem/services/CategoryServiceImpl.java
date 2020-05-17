package com.sda.studysystem.services;

import com.sda.studysystem.models.Category;
import com.sda.studysystem.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public boolean createCategory(Category category) {
        if (category == null) {
            return false;
        }
        category.setCategoryId(category.getCategoryId());
        categoryRepo.save(category);
        return true;
    }

    @Override
    public boolean updateCategory(Category category) {
        if (category == null || categoryRepo.existsById(category.getCategoryId())) {
            return false;
        }
        categoryRepo.saveAndFlush(category);
        return true;
    }

    @Override
    public Category getById(Long categoryId) {
        return categoryRepo.getOne(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public boolean deleteCategoryById(Long categoryId) {
        Category category = getById(categoryId);
        if (categoryId == null) {
            return false;
        }
        category.setActive(false);
        updateCategory(category);
        return true;
    }

    @Override
    public boolean restoreCategoryById(Long categoryId) {
        Category category = getById(categoryId);
        if (categoryId == null) {
            return false;
        }
        category.setActive(true);
        return updateCategory(category);
    }
}
