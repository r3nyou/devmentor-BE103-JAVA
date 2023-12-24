package com.devmentor.restfulapidemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Qualifier("bookCourseEvent")
    @Autowired
    private Event event;

    @Value("${bookCourse.message}")
    private String envMessage;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/register-success")
    public String registerSuccess() {
        String content = event.getContent("allen");

        return content;
    }

    @GetMapping("/book-course")
    public String bookCourse() {
        String content = event.getContent("allen");

        return content;
    }

}
