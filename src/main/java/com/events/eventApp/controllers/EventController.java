package com.events.eventApp.controllers;


import com.events.eventApp.persistence.entities.Event;
import com.events.eventApp.persistence.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventRepository eventRepository;


    @GetMapping("/events")
    public List<Event> getEvents() {
        List<Event> events = eventRepository.findAll();
        return events;
    }

    @GetMapping("/{id}")

    public List<Event> getEventById(@PathVariable("id") Integer id) {
        List<Event> events = eventRepository.findByEventId(id);
        return events;
    }


    @PostMapping("/new-event")
    public ResponseEntity<String> createEvent(@RequestBody Event event, Principal principal) {
        Event newEvent = new Event();
        String username = principal.getName();
        newEvent.setEventOwner(username);
        newEvent.setDate(event.getDate());
        newEvent.setParticipants(event.getParticipants());
        eventRepository.save(newEvent);
        return ResponseEntity.ok().body("Evento creado con exito");
    }
}
