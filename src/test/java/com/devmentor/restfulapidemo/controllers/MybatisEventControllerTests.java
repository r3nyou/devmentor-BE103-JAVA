package com.devmentor.restfulapidemo.controllers;

import com.devmentor.restfulapidemo.dao.EventDao;
import com.devmentor.restfulapidemo.entities.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Date;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@AutoConfigureMockMvc
public class MybatisEventControllerTests {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_get_event() throws Exception {
        // arrange
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("name", "event 1");
        jsonObject.put("triggerTime", "2024-12-31 15:30:45");
        jsonObject.put("createdAt", "2024-12-31T07:30:45.000+00:00");
        jsonObject.put("eventNotifyMessages", JSONObject.NULL);
        mockMvc.perform(get("/mybatis/events/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.content().string(is(event.toString())));

        // assert
        ObjectMapper mapper = new ObjectMapper();
        Event event = mapper.readValue(jsonObject.toString(), Event.class);
        Assertions.assertEquals("event 1", event.getName());
    }

    @Test
    public void test_create_event() throws Exception {
        // arrange
        Event event = new Event();
        event.setName("foobar");
        event.setTriggerTime(new Date(System.currentTimeMillis()));

        ObjectMapper mapper = new ObjectMapper();

        // act
        mockMvc.perform(post("/mybatis/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(event)))
                .andExpect(status().isOk())
                .andExpect(content().string(is("create event")));
    }
}
