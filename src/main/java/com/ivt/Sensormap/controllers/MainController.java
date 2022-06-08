package com.ivt.Sensormap.controllers;

import com.ivt.Sensormap.models.Sensor;
import com.ivt.Sensormap.models.User;
import com.ivt.Sensormap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.time.LocalDateTime;

@Controller//Навигация
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(Model model) {
        return "main";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser   (@RequestParam("username") String username,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             Model model) {

        User userFromDb =userRepository.findByUsername(username);
        if(userFromDb!=null){
            return "registration";
        }
        User user= new User();
        user.setUsername(username);
        user.setEmail(email);
        String encrptedPwd = passwordEncoder.encode(password);
        user.setPassword(encrptedPwd);
        user.setIsActive(1);
        user.setRole("admine");
        user.setRegistrationDate(LocalDateTime.now());
        userRepository.save(user);

        return "main";
    }

}
