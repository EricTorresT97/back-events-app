package com.events.eventApp.persistence.repositories;

import com.events.eventApp.persistence.entities.UserEventAssociation;
import com.events.eventApp.persistence.entities.UserEventAssociationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventAssociationRepository extends JpaRepository<UserEventAssociation, UserEventAssociationId> {
}
