package com.events.eventApp.persistence.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
 @Data
public class UserItemEventAssociation implements Serializable {
    @Id
    @EmbeddedId
    private UserItemEventAssociationId id;



    @ManyToOne
    @JoinColumn(name = "userId",updatable = false,insertable = false,referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "itemId",updatable = false,insertable = false,referencedColumnName = "id")
    private Item item;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "eventId",updatable = false,insertable = false,referencedColumnName = "id")
    private Event event;

}
