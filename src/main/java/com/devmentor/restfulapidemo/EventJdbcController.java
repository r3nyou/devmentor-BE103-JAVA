package com.devmentor.restfulapidemo;

import com.devmentor.restfulapidemo.Entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EventJdbcController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/jdbc/events")
    public String insert(@RequestBody Event event) {
        String sql = "INSERT INTO events (name, trigger_time, created_at) VALUES (?, ?, ?)";
        Object[] object = new Object[] {event.getName(), event.getTriggerTime(), new Timestamp(System.currentTimeMillis())};

        jdbcTemplate.update(sql, object);

        return "Create Event";
    }

    @GetMapping("/jdbc/events")
    public List<Event> selectAll() {
        String sql = "SELECT * FROM events";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Event.class));
    }

    @GetMapping("/jdbc/events/{id}")
    public Event select(@PathVariable Integer id) {
        String sql = "SELECT * FROM events WHERE id=?";
        Object[] object = new Object[] {id};

        List<Event> list = jdbcTemplate.query(sql, object, BeanPropertyRowMapper.newInstance(Event.class));
        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    @PutMapping("/jdbc/events/{id}")
    public String update(@PathVariable Integer id, @RequestBody Event event) {
        String sql = "UPDATE events SET name=?, trigger_time=? WHERE id=?";
        Object[] object = new Object[] {event.getName(), event.getTriggerTime(), id};

        jdbcTemplate.update(sql, object);

        return "Update Event";
    }
}
