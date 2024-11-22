package com.events.eventApp.persistence.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserEventAssociationId implements Serializable {
    private int userId;
    private int eventId;
}