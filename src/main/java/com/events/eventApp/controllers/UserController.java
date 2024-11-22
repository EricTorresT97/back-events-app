package com.events.eventApp.controllers;


import com.events.eventApp.config.Encoder;
import com.events.eventApp.persistence.entities.User;
import com.events.eventApp.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    public static void findUserByUsername(String username) {
    }


    @GetMapping("/{id}")
    public User getProfileById(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {

        String encryptedPassword = Encoder.passwordencoder().encode(user.getPassword());
//      user.setUsername(user.getEmail());
        user.setPassword(encryptedPassword);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        User userCreated = userRepository.save(user);
        return ResponseEntity.ok().body("User Created" + userCreated);
    }

}
