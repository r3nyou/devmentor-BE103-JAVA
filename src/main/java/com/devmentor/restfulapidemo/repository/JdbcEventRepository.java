package com.devmentor.restfulapidemo.repository;

import com.devmentor.restfulapidemo.Entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class JdbcEventRepository implements EventRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Event event) {
        String sql = "INSERT INTO events (name, trigger_time, created_at) VALUES (?, ?, ?)";
        Object[] object = new Object[] {event.getName(), event.getTriggerTime(), new Timestamp(System.currentTimeMillis())};

        return jdbcTemplate.update(sql, object);
    }

    @Override
    public int update(Long id, Event event) {
        String sql = "UPDATE events SET name=?, trigger_time=? WHERE id=?";
        Object[] object = new Object[] {event.getName(), event.getTriggerTime(), id};

        return jdbcTemplate.update(sql, object);
    }

    @Override
    public List<Event> selectAll() {
        String sql = "SELECT * FROM events";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Event.class));
    }

    @Override
    public Event select(Long id) {
        String sql = "SELECT * FROM events WHERE id=?";
        Object[] object = new Object[] {id};

        List<Event> list = jdbcTemplate.query(sql, object, BeanPropertyRowMapper.newInstance(Event.class));
        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }
}
