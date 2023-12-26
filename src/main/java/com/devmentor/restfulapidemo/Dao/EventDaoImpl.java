package com.devmentor.restfulapidemo.Dao;

import com.devmentor.restfulapidemo.entities.Event;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventDaoImpl implements EventDao {
    private EntityManager entityManager;

    @Autowired
    public EventDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Event event) {
        entityManager.persist(event);
    }
}
