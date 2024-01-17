package com.devmentor.restfulapidemo;

import com.devmentor.restfulapidemo.Entities.Event;
import com.devmentor.restfulapidemo.repository.JdbcEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventJdbcController {
    @Autowired
    JdbcEventRepository jdbcEventRepository;

    @PostMapping("/jdbc/events")
    public String insert(@RequestBody Event event) {
        jdbcEventRepository.insert(event);

        return "Create Event";
    }

    @PutMapping("/jdbc/events/{id}")
    public String update(@PathVariable Long id, @RequestBody Event event) {
        jdbcEventRepository.update(id, event);

        return "Update Event";
    }

    @GetMapping("/jdbc/events")
    public List<Event> selectAll() {
        return jdbcEventRepository.selectAll();
    }

    @GetMapping("/jdbc/events/{id}")
    public Event select(@PathVariable Long id) {
        return jdbcEventRepository.select(id);
    }
}
