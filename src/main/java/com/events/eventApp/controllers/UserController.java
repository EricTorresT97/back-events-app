package com.events.eventApp.controllers;

import com.events.eventApp.persistence.entities.User;
import com.events.eventApp.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    public static void findUserByUsername(String username) {
    }


    @GetMapping("/profile")
    public User getProfileById(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User userCreated = userRepository.save(user);
        return ResponseEntity.ok().body("User Created");
    }

}