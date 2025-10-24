package com.jehad.ticket.ticket_validation;

import com.jehad.ticket.common.TicketBaseEntity;
import com.jehad.ticket.ticket.Ticket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Table(name = "ticket_validations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TicketValidation extends TicketBaseEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    TicketValidationStatus status;

    @Column(name = "validation_method", nullable = false)
    @Enumerated(EnumType.STRING)
    TicketValidationMethod validationMethod;

//  ###################################################
//  #               RelationShips                     #
//  ###################################################
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

}
