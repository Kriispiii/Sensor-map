package com.ivt.Sensormap.controllers;

import com.ivt.Sensormap.models.Sensor;
import com.ivt.Sensormap.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//Навигация
public class MainController {

    @Autowired
    private SensorRepository sensorRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("sensor-map", "Main");
        //создание объекта яндекс карты из таблицы
        Iterable<Sensor> sensors = sensorRepository.findAll();
        model.addAttribute("sensors",sensors);
        return "main";
    }

}
