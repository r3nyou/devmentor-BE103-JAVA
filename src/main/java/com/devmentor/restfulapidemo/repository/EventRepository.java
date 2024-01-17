package com.devmentor.restfulapidemo.repository;

import com.devmentor.restfulapidemo.Entities.Event;

import java.util.List;

public interface EventRepository {
    int insert(Event event);

    int update(Long id, Event event);

    List<Event> selectAll();

    Event select(Long id);
}
