package com.sda.studysystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for Home Page
 *
 * @author Tanel
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    private String showHomePage(){
        return "home";
    }
}
