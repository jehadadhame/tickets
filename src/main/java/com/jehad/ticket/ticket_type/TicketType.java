package com.jehad.ticket.ticket_type;

import com.jehad.ticket.common.TicketBaseEntity;
import com.jehad.ticket.event.Event;
import com.jehad.ticket.ticket.Ticket;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.aspectj.lang.annotation.Aspect;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ticket-types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TicketType extends TicketBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price",  nullable = false)
    private double price;

    @Column(name = "total_available")
    private int totalAvailable;

//  ###################################################
//  #               RelationShips                     #
//  ###################################################

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;


    @OneToMany(mappedBy = "ticketType", cascade =  CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

}
