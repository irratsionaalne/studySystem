package com.sda.studysystem.controllers;

import com.sda.studysystem.models.Category;
import com.sda.studysystem.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String showAllCategorys(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "show-all-categories";
    }

    @GetMapping("/add")
    public String addCategoryForm(Model model) {
        return "add-category";
    }

    @PostMapping("/addCategory")
    public String addCategory(Category category, Model model) {
        boolean createResult = categoryService.createCategory(category);
        category.setActive(true);

        if (createResult) {
            model.addAttribute("message", "Category has been successfully created.");
            model.addAttribute("messageType", "success");
            return showAllCategorys(model);
        } else {
            model.addAttribute("category", category);
            model.addAttribute("message", "Error creating category.");
            model.addAttribute("messageType", "error");
            return addCategoryForm(model);
        }
    }

    @GetMapping("/update")
    public String updateCategoryForm(Model model) {
        return "update-category";
    }

    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") Long categoryId, Category category, Model model) {
        category.setCategoryId(categoryId);
        boolean updateResult = categoryService.updateCategory(category);

        if (updateResult) {
            model.addAttribute("message", "Category has been successfully updated.");
            model.addAttribute("messageType", "success");
            return showAllCategorys(model);
        } else {
            model.addAttribute("category", category);
            model.addAttribute("message", "Error updating category.");
            model.addAttribute("messageType", "error");
            return updateCategoryForm(model);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long categoryId, Model model) {
        boolean deleteResult = categoryService.deleteCategoryById(categoryId);

        if (deleteResult) {
            model.addAttribute("message", "Category has been successfully deleted.");
            model.addAttribute("messageType", "success");
        } else {
            model.addAttribute("message", "Error deleting category.");
            model.addAttribute("messageType", "error");
        }
        return showAllCategorys(model);
    }

    @GetMapping("/restore/{id}")
    public String restoreCategory(@PathVariable("id") Long categoryId, Model model) {
        boolean restoreResult = categoryService.restoreCategoryById(categoryId);

        if (restoreResult) {
            model.addAttribute("message", "Category has been successfully restored.");
            model.addAttribute("messageType", "success");
        } else {
            model.addAttribute("message", "Error restoring category.");
            model.addAttribute("messageType", "error");
        }
        return showAllCategorys(model);
    }
}
