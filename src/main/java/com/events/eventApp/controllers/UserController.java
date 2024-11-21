package com.events.eventApp.controllers;

import com.events.eventApp.persistence.entities.User;
import com.events.eventApp.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;


    @GetMapping("/profile")
    public List<User> getProfileById(@PathVariable("id") Integer id) {
        List <User> user = userRepository.FindByUserId(id);
        return user;
    }

}
