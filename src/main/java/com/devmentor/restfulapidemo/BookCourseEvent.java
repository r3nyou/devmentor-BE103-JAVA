package com.devmentor.restfulapidemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class BookCourseEvent implements Event {
    @Override
    public String getContent(String message) {
        return "Book Course " + message;
    }

    @Bean
    public BookCourseEvent getEvent() {
        return new BookCourseEvent();
    }
}
