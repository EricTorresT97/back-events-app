package com.events.eventApp.persistence.repositories;

import com.events.eventApp.persistence.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
