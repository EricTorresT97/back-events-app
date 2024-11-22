package com.events.eventApp.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "events")
public class Event implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private User eventOwner;
    private String eventLocation;
    private String name;
    private Date date;
    private List<User> participants;
}
