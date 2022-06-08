package com.ivt.Sensormap.controllers;

import com.ivt.Sensormap.models.Sensor;
import com.ivt.Sensormap.models.User;
import com.ivt.Sensormap.repository.SensorRepository;
import com.ivt.Sensormap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class sensorContorller {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @PostMapping("/")
    public String addSensor  (@RequestParam("latitude") Float latitude,
                              @RequestParam("longitude") Float longitude,
                             Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User userFromDb =userRepository.findByUsername(currentPrincipalName);

        Sensor sensor= new Sensor(latitude,longitude);
        sensor.setUserUser(userFromDb);
        sensorRepository.save(sensor);
        return "main";
    }


}
