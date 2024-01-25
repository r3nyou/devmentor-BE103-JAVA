package com.devmentor.restfulapidemo.service;

import com.devmentor.restfulapidemo.entities.Event;
import com.devmentor.restfulapidemo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEvent(int id) {
        return eventRepository.findById(id).get();
    }

    @Override
    public void updateEvent(int id, Event updateEvent) {
        Event event = this.getEvent(id);
        if (event != null) {
            event.setName(updateEvent.getName());
            event.setTriggerTime(updateEvent.getTriggerTime());
            eventRepository.save(event);
        }
    }

    @Override
    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }
}
