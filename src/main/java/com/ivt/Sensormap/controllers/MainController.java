package com.ivt.Sensormap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//подгрузка сайта
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("sensor-map", "Main");
        return "main";
    }

}
