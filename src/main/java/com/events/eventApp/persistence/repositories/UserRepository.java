package com.events.eventApp.persistence.repositories;

import com.events.eventApp.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
