package com.jehad.ticket.ticket_type;

import com.jehad.ticket.event.Event;
import com.jehad.ticket.validation.groups.OnCreate;
import com.jehad.ticket.validation.groups.OnUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeDTO {
    @NotNull(groups = OnUpdate.class)
    @Null(groups = OnCreate.class)
    private UUID id;

    @NotBlank(message = "name can't be empty")
    private String name;

    private String description;

    @NotNull(message = "price is required")
    @PositiveOrZero(message = "price can't be negative")
    private double price;

    private int totalAvailable;

    private Event event;

}
