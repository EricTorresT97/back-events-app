package com.events.eventApp.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Getter
@Setter
public class UserEventAssociation implements Serializable {
    @Id
    @EmbeddedId
    private UserEventAssociationId id;

    @ManyToOne
    @JoinColumn(name = "userId",updatable = false,insertable = false,referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "eventId",updatable = false,insertable = false,referencedColumnName = "id")
    private Event event;
}
