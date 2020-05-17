package com.sda.studysystem.controllers;

import com.sda.studysystem.models.School;
import com.sda.studysystem.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping("")
    public String showAllSchools(Model model) {
        List<School> schools = schoolService.getAllSchools();
        model.addAttribute("schools", schools);
        return "show-all-schools";
    }

    @GetMapping("/add")
    public String addSchoolForm(Model model) {
        return "add-school";
    }

    @PostMapping("/addSchool")
    public String addSchool(School school, Model model) {
        boolean createResult = schoolService.createSchool(school);
        school.setActive(true);

        if (createResult) {
            model.addAttribute("message", "School has been successfully created.");
            model.addAttribute("messageType", "success");
            return showAllSchools(model);
        } else {
            model.addAttribute("school", school);
            model.addAttribute("message", "Error creating school.");
            model.addAttribute("messageType", "error");
            return addSchoolForm(model);
        }
    }

    @GetMapping("/update")
    public String updateSchoolForm(Model model) {
        return "update-school";
    }

    @PostMapping("/update/{id}")
    public String updateSchool(@PathVariable("id") Long schoolId, School school, Model model) {
        school.setSchoolId(schoolId);
        boolean updateResult = schoolService.updateSchool(school);

        if (updateResult) {
            model.addAttribute("message", "School has been successfully updated.");
            model.addAttribute("messageType", "success");
            return showAllSchools(model);
        } else {
            model.addAttribute("school", school);
            model.addAttribute("message", "Error updating school.");
            model.addAttribute("messageType", "error");
            return updateSchoolForm(model);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteSchool(@PathVariable("id") Long schoolId, Model model) {
        boolean deleteResult = schoolService.deleteSchoolById(schoolId);

        if (deleteResult) {
            model.addAttribute("message", "School has been successfully deleted.");
            model.addAttribute("messageType", "success");
        } else {
            model.addAttribute("message", "Error deleting school.");
            model.addAttribute("messageType", "error");
        }
        return showAllSchools(model);
    }

    @GetMapping("/restore/{id}")
    public String restoreSchool(@PathVariable("id") Long schoolId, Model model) {
        boolean restoreResult = schoolService.restoreSchoolById(schoolId);

        if (restoreResult) {
            model.addAttribute("message", "School has been successfully restored.");
            model.addAttribute("messageType", "success");
        } else {
            model.addAttribute("message", "Error restoring school.");
            model.addAttribute("messageType", "error");
        }
        return showAllSchools(model);
    }
}
