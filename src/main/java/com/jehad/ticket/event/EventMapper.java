package com.jehad.ticket.event;

import com.jehad.ticket.ticket_type.TicketTypeMapper;

public class EventMapper {
    public static Event toEntity(EventDTO dto) {
        Event entity = new Event();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setStart(dto.getStart());
        entity.setEnd(dto.getEnd());
        entity.setSalesStart(dto.getSalesStart());
        entity.setSalesEnd(dto.getSalesEnd());
        entity.setVenue(dto.getVenue());
        entity.setStatus(dto.getStatus());
        entity.setTicketTypes(dto.getTicketTypes().stream().map(TicketTypeMapper::toEntity).toList());
        return entity;
    }
    public static EventDTO toDTO(Event event) {
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setStart(event.getStart());
        dto.setEnd(event.getEnd());
        dto.setSalesStart(event.getSalesStart());
        dto.setSalesEnd(event.getSalesEnd());
        dto.setVenue(event.getVenue());
        dto.setStatus(event.getStatus());
        dto.setTicketTypes(event.getTicketTypes().stream().map(TicketTypeMapper::toDTO).toList());
        return dto;
    }
}
