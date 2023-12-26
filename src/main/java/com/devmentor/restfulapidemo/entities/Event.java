package com.devmentor.restfulapidemo.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name") private String name;
    @Column(name = "trigger_time") private Date triggerTime;
    @Column(name = "create_at") private Date createdAt;
}
