package com.jehad.ticket.event;

import com.jehad.ticket.exceptions.UserNotFoundException;
import com.jehad.ticket.user.User;
import com.jehad.ticket.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    @Override
    public EventDTO createEvent(UUID organizerId, EventDTO event) {
        User organizer = userRepository.findById(organizerId)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("user with id '%' not found", organizerId)
                )
        );
        Event eventToCreate = EventMapper.toEntity(event);
        eventToCreate.setOrganizer(organizer);
        return EventMapper.toDTO(eventRepository.save(eventToCreate));

    }
}
