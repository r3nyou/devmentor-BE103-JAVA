package com.devmentor.restfulapidemo.dao;

import com.devmentor.restfulapidemo.entities.Event;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventDao {
    int create(Event event);
    Event get(int eventId);
    List<Event> getAll();
    String update(Event event);
    String delete(int eventId);


    Event getEventNotifyMessage(int eventId);
}
