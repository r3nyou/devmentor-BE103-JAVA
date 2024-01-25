package com.devmentor.restfulapidemo.repository;

import com.devmentor.restfulapidemo.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {
}
