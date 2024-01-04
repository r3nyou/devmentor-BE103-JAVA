package com.devmentor.restfulapidemo;

import com.devmentor.restfulapidemo.Entities.Event;
import com.devmentor.restfulapidemo.Entities.EventRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EventJDBCController {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/jdbc/events")
    public String insert(@RequestBody Event event) {
        String sql = "INSERT INTO events(name, trigger_time, created_at) VALUES (:name, :triggerTime, :createdAt)";
        Map<String, Object> map = new HashMap<>();
        map.put("name", event.getName());
        map.put("triggerTime", event.getTriggerTime());
        map.put("createdAt", new Timestamp(System.currentTimeMillis()));

        namedParameterJdbcTemplate.update(sql, map);

        return "Create Event";
    }

    @GetMapping("/jdbc/events/{id}")
    public Event select(@PathVariable Integer id) {
       String sql = "SELECT * FROM events WHERE id=:id";
       Map<String, Object> map = new HashMap<>();
       map.put("id", id);

       List<Event> list = namedParameterJdbcTemplate.query(sql , map, new EventRowMapper());
       if (list.isEmpty()) {
           return null;
       }

       return list.get(0);
    }
}
