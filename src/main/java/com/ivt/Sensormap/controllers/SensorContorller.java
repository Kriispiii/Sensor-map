package com.ivt.Sensormap.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivt.Sensormap.models.Sensor;
import com.ivt.Sensormap.models.User;
import com.ivt.Sensormap.repository.SensorRepository;
import com.ivt.Sensormap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SensorContorller {

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

    @GetMapping("/jsonData")
    public void  jsonData(HttpServletResponse response) throws IOException {
        List<Sensor> sensors=sensorRepository.findAll();
        String json = new ObjectMapper().writeValueAsString(sensors);
        response.getWriter().write(json);
    }

    @PostMapping("/update")
    public String updateSensor(@RequestParam("idUpdate") Integer id,
                                    @RequestParam("latitudeUpdate") Float latitude,
                                    @RequestParam("longitudeUpdate") Float longitude,
                                    Model model) {
        Sensor sensor = sensorRepository.findById(id).orElseThrow();
        sensor.setLatitude(latitude);
        sensor.setLongitude(longitude);
        sensorRepository.save(sensor);
        return "main";
    }

    @PostMapping("/delete")
    public String deleteSensor(@RequestParam("idDelete") Integer id,Model model){
        Sensor sensor= sensorRepository.findById(id).orElseThrow();
        sensorRepository.delete(sensor);
        return "main";
    }



}
