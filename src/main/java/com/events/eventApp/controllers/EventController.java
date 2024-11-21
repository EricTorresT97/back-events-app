package com.events.eventApp.controllers;


import com.events.eventApp.persistence.entities.Event;
import com.events.eventApp.persistence.entities.User;
import com.events.eventApp.persistence.entities.UserItemEventAssociation;
import com.events.eventApp.persistence.repositories.EventRepository;
import com.events.eventApp.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;


// Si esta ruta esta desprotegida, ¿pq no logramos ?
    @GetMapping("/event")
    public List<Event> getEvents() {
        List<Event> events = eventRepository.findAll();
        return events;
    }




    @GetMapping("/{id}")
    public Event getEventById(@PathVariable("id") Integer id) {
        Event event = eventRepository.findById(id).orElse(null);
        return event;
    }



    @PostMapping("/new")
    public ResponseEntity<String> createEvent(@RequestBody Event event, Principal principal) {
        Event newEvent = new Event();
        String username = principal.getName();
        User u = userRepository.findByUsername(username);
        newEvent.setEventOwner(u);
        newEvent.setDate(event.getDate());
        newEvent.setParticipants(event.getParticipants());
        newEvent.setEventLocation(event.getEventLocation());
        eventRepository.save(newEvent);
        return ResponseEntity.ok().body("Evento creado con exito");
    }

    @PostMapping("addParticipant/{eventId}/{userId}")
    public ResponseEntity<String> addParticipant(@PathVariable("eventId") Integer eventId, @PathVariable("userId") Integer userId) {
        Event event = eventRepository.findById(eventId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);


        UserItemEventAssociation uia = new UserItemEventAssociation();
        uia.setUser(user);

        userRepository.save(user);


        event.getParticipants().add(user);
        eventRepository.save(event);
        return ResponseEntity.ok().body("Participante añadido con exito");
    }
}
