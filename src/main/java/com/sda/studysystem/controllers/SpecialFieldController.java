package com.sda.studysystem.controllers;

import com.sda.studysystem.models.SpecialField;
import com.sda.studysystem.services.SpecialFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/specialField")
public class SpecialFieldController {
    @Autowired
    private SpecialFieldService specialFieldService;

    @GetMapping("")
    public String showAllSpecialFields(Model model) {
        List<SpecialField> specialFields = specialFieldService.getAllSpecialFields();
        model.addAttribute("specialFields", specialFields);
        return "show-all-specialFields";
    }

    @GetMapping("/add")
    public String addSpecialFieldForm(Model model) {
        return "add-specialField";
    }

    @PostMapping("/addSpecialField")
    public String addSpecialField(SpecialField specialField, Model model) {
        boolean createResult = specialFieldService.createSpecialField(specialField);
        specialField.setActive(true);

        if (createResult) {
            model.addAttribute("message", "SpecialField has been successfully created.");
            model.addAttribute("messageType", "success");
            return showAllSpecialFields(model);
        } else {
            model.addAttribute("specialField", specialField);
            model.addAttribute("message", "Error creating specialField.");
            model.addAttribute("messageType", "error");
            return addSpecialFieldForm(model);
        }
    }

    @GetMapping("/update")
    public String updateSpecialFieldForm(Model model) {
        return "update-specialField";
    }

    @PostMapping("/update/{id}")
    public String updateSpecialField(@PathVariable("id") Long specialFieldId, SpecialField specialField, Model model) {
        specialField.setSpecialFieldId(specialFieldId);
        boolean updateResult = specialFieldService.updateSpecialField(specialField);

        if (updateResult) {
            model.addAttribute("message", "SpecialField has been successfully updated.");
            model.addAttribute("messageType", "success");
            return showAllSpecialFields(model);
        } else {
            model.addAttribute("specialField", specialField);
            model.addAttribute("message", "Error updating specialField.");
            model.addAttribute("messageType", "error");
            return updateSpecialFieldForm(model);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteSpecialField(@PathVariable("id") Long specialFieldId, Model model) {
        boolean deleteResult = specialFieldService.deleteSpecialFieldById(specialFieldId);

        if (deleteResult) {
            model.addAttribute("message", "SpecialField has been successfully deleted.");
            model.addAttribute("messageType", "success");
        } else {
            model.addAttribute("message", "Error deleting specialField.");
            model.addAttribute("messageType", "error");
        }
        return showAllSpecialFields(model);
    }

    @GetMapping("/restore/{id}")
    public String restoreSpecialField(@PathVariable("id") Long specialFieldId, Model model) {
        boolean restoreResult = specialFieldService.restoreSpecialFieldById(specialFieldId);

        if (restoreResult) {
            model.addAttribute("message", "SpecialField has been successfully restored.");
            model.addAttribute("messageType", "success");
        } else {
            model.addAttribute("message", "Error restoring specialField.");
            model.addAttribute("messageType", "error");
        }
        return showAllSpecialFields(model);
    }
}
