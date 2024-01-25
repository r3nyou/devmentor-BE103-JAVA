package com.devmentor.restfulapidemo.service;

import com.devmentor.restfulapidemo.entities.Event;

import java.util.List;

public interface EventService {
    void save(Event event);
    List<Event> findAll();

    Event getEvent(int id);

    void updateEvent(int id, Event event);

    void deleteEvent(int id);
}
