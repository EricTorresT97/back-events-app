package com.events.eventApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {
    @Bean (name = "passwordEncoder")
    BCryptPasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder();
    }
}
