package com.jehad.ticket.event;

import java.util.UUID;

public interface EventService {
    EventDTO createEvent(UUID organizerId, EventDTO event) ;
 }
