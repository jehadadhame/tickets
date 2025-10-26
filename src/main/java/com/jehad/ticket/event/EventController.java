package com.jehad.ticket.event;

import com.jehad.ticket.validation.groups.OnCreate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class EventController {
    private final EventService eventService;

    @PostMapping("")
    @Validated(OnCreate.class)
    public ResponseEntity<EventDTO> createEvent(@AuthenticationPrincipal Jwt jwt, UUID organizerId,@Valid @RequestBody EventDTO event) {
        UUID userId = UUID.fromString(jwt.getSubject());
        EventDTO result =  eventService.createEvent(userId, event);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


}
