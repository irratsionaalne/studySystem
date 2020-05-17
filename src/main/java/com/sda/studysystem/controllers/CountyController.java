package com.sda.studysystem.controllers;

import com.sda.studysystem.models.County;
import com.sda.studysystem.services.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/county")
public class CountyController {
    @Autowired
    private CountyService countyService;

    @GetMapping("")
    public String showAllCounties(Model model) {
        List<County> counties = countyService.getAllCounties();
        model.addAttribute("counties", counties);
        return "show-all-counties";
    }

    @GetMapping("/add")
    public String addCountyForm(Model model) {
        return "add-county";
    }

    @PostMapping("/addCounty")
    public String addCounty(County county, Model model) {
        boolean createResult = countyService.createCounty(county);
        county.setActive(true);

        if (createResult) {
            model.addAttribute("message", "County has been successfully created.");
            model.addAttribute("messageType", "success");
            return showAllCounties(model);
        } else {
            model.addAttribute("county", county);
            model.addAttribute("message", "Error creating county.");
            model.addAttribute("messageType", "error");
            return addCountyForm(model);
        }
    }

    @GetMapping("/update")
    public String updateCountyForm(Model model) {
        return "update-county";
    }

    @PostMapping("/update/{id}")
    public String updateCounty(@PathVariable("id") Long countyId, County county, Model model) {
        county.setCountyId(countyId);
        boolean updateResult = countyService.updateCounty(county);

        if (updateResult) {
            model.addAttribute("message", "County has been successfully updated.");
            model.addAttribute("messageType", "success");
            return showAllCounties(model);
        } else {
            model.addAttribute("county", county);
            model.addAttribute("message", "Error updating county.");
            model.addAttribute("messageType", "error");
            return updateCountyForm(model);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCounty(@PathVariable("id") Long countyId, Model model) {
        boolean deleteResult = countyService.deleteCountyById(countyId);

        if (deleteResult) {
            model.addAttribute("message", "County has been successfully deleted.");
            model.addAttribute("messageType", "success");
        } else {
            model.addAttribute("message", "Error deleting county.");
            model.addAttribute("messageType", "error");
        }
        return showAllCounties(model);
    }

    @GetMapping("/restore/{id}")
    public String restoreCounty(@PathVariable("id") Long countyId, Model model) {
        boolean restoreResult = countyService.restoreCountyById(countyId);

        if (restoreResult) {
            model.addAttribute("message", "County has been successfully restored.");
            model.addAttribute("messageType", "success");
        } else {
            model.addAttribute("message", "Error restoring county.");
            model.addAttribute("messageType", "error");
        }
        return showAllCounties(model);
    }
}
