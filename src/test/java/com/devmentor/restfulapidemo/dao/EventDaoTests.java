package com.devmentor.restfulapidemo.dao;

import com.devmentor.restfulapidemo.entities.Event;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EventDaoTests {

    @Autowired
    private EventDao eventDao;

    @Test
    public void test_create_eventDao() {
        // arrange
        String eventName = "foobar";
        Event event = new Event();
        event.setName(eventName);
        event.setTriggerTime(new Date(System.currentTimeMillis()));
        event.setCreatedAt(new Date(System.currentTimeMillis()));

        // act
        eventDao.create(event);

        // assert
        Event inserted = eventDao.get(2);
        Assertions.assertNotNull(inserted);
        Assertions.assertEquals(2, inserted.getId());
        Assertions.assertEquals(eventName, inserted.getName());
    }

    @Test
    public void test_get_eventDao_by_id() {
        // arrange

        // act
        Event inserted = eventDao.get(1);

        // assert
        Assertions.assertNotNull(inserted);
        Assertions.assertEquals(1, inserted.getId());
    }
}
