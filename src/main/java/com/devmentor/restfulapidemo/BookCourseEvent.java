package com.devmentor.restfulapidemo;

import org.springframework.stereotype.Component;

@Component
public class BookCourseEvent implements Event {
    @Override
    public String getContent(String message) {
        return "Book Course " + message;
    }
}
