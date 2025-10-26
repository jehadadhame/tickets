package com.jehad.ticket.ticket_type;

public class TicketTypeMapper {
    public static TicketType toEntity(TicketTypeDTO dto) {
        TicketType entity = new TicketType();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        entity.setTotalAvailable(dto.getTotalAvailable());
        return entity;
    }

    public static TicketTypeDTO toDTO(TicketType entity) {
        TicketTypeDTO dto = new TicketTypeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDescription(entity.getDescription());
        dto.setTotalAvailable(entity.getTotalAvailable());
        return dto;
    }
}
