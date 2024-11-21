package com.events.eventApp.persistence.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserItemEventAssociationId implements Serializable {
    private int userId;
    private int itemId;
    private int eventId;
}
