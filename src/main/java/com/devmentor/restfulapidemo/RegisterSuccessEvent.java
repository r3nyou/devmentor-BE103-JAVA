package com.devmentor.restfulapidemo;

import org.springframework.stereotype.Component;

@Component
public class RegisterSuccessEvent implements Event {
    @Override
    public String getContent(String message) {
        return "register success " + message;
    }
}
