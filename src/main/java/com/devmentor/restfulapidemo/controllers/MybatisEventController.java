package com.devmentor.restfulapidemo.controllers;

import com.devmentor.restfulapidemo.dao.EventDao;
import com.devmentor.restfulapidemo.entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class MybatisEventController {
    @Autowired
    private EventDao eventDao;
    @GetMapping("/mybatis/events/{eventId}")
    public Event get(@PathVariable int eventId) {
        return eventDao.get(eventId);
    }

    @PostMapping("/mybatis/events")
    public String create(@RequestBody Event event) {
        event.setCreatedAt(new Date(System.currentTimeMillis()));
        eventDao.create(event);
        return "create event";
    }

    @GetMapping("/mybatis/event/messages/{eventId}")
    public Event getEventNotifyMessage(@PathVariable int eventId) {
       return eventDao.getEventNotifyMessage(eventId);
    }
}
