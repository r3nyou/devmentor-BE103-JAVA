package com.devmentor.restfulapidemo.entities;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventRowMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();
        event.setId(rs.getLong("id"));
        event.setName(rs.getString("name"));
        event.setTriggerTime(rs.getTimestamp("trigger_time"));
        event.setCreatedAt(rs.getTimestamp("created_at"));

        return event;
    }
}
