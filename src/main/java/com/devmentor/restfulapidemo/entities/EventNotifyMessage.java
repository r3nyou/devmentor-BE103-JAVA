package com.devmentor.restfulapidemo.entities;

public class EventNotifyMessage {
    private Long id;
    private Long eventId;
    private Long notifyChannelId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getNotifyChannelId() {
        return notifyChannelId;
    }

    public void setNotifyChannelId(Long notifyChannelId) {
        this.notifyChannelId = notifyChannelId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;
}
