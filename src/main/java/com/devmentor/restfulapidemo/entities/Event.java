package com.devmentor.restfulapidemo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Event {
    private Long id;
    private String name;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:s")
    private Date triggerTime;
    private Date createdAt;

    private List<EventNotifyMessage> eventNotifyMessages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<EventNotifyMessage> getEventNotifyMessages() {
        return eventNotifyMessages;
    }

    public void setEventNotifyMessages(List<EventNotifyMessage> eventNotifyMessages) {
        this.eventNotifyMessages = eventNotifyMessages;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", triggerTime=" + triggerTime +
                '}';
    }
}
