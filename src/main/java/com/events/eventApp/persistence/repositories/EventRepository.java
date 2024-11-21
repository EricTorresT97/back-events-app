package com.events.eventApp.persistence.repositories;

import com.events.eventApp.persistence.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByEventId(Integer id);
}
