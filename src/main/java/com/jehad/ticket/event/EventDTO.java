package com.jehad.ticket.event;

import com.jehad.ticket.ticket_type.TicketTypeDTO;
import com.jehad.ticket.user.User;
import com.jehad.ticket.validation.groups.OnCreate;
import com.jehad.ticket.validation.groups.OnUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    @NotNull(groups = OnUpdate.class)
    @Null(groups = OnCreate.class)
    private UUID id;

    @NotBlank(message = "name can't be empty")
    private String name;

    @NotBlank(message = "venue can't be empty")
    private String venue;

    @NotBlank(message = "event status must be provided")
    private EventStatus status;

    private LocalDateTime start;

    private LocalDateTime end;

    private LocalDateTime salesStart;

    private LocalDateTime salesEnd;

    @NotEmpty(message = "you have to provide at least one ticket type")
    @Valid
    private List<TicketTypeDTO> ticketTypes = new ArrayList<>();

    private List<User> attendees = new ArrayList<>();

    private List<User> staff = new ArrayList<>();

}
