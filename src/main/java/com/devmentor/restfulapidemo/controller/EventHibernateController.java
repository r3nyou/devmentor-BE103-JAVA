package com.devmentor.restfulapidemo.controller;

import com.devmentor.restfulapidemo.entities.Event;
import com.devmentor.restfulapidemo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class EventHibernateController {
    @Autowired
    private EventService eventService;

    @PostMapping("/hibernate/events")
    public String createEvent(@RequestBody Event event) {
        event.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        eventService.save(event);

        return "create event";
    }

    @GetMapping("/hibernate/events")
    public Iterable<Event> findAll() {
        return eventService.findAll();
    }

    @GetMapping("/hibernate/events/{id}")
    public Event getEvent(@PathVariable int id) {
        return eventService.getEvent(id);
    }

    @PutMapping("/hibernate/events/{id}")
    public String updateEvent(@PathVariable int id, @RequestBody Event event) {
        eventService.updateEvent(id, event);

        return "update event";
    }

    @DeleteMapping("/hibernate/events/{id}")
    public String deleteEvent(@PathVariable int id) {
        eventService.deleteEvent(id);

        return "delete event";
    }
}
