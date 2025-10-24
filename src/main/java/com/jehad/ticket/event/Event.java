package com.jehad.ticket.event;

import com.jehad.ticket.common.TicketBaseEntity;
import com.jehad.ticket.ticket_type.TicketType;
import com.jehad.ticket.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Event extends TicketBaseEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "venue", nullable = false)
    private String venue;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",  nullable = false)
    private EventStatus status;

//  ###################################################
//  #                   Dates                         #
//  ###################################################

    @Column(name = "start_at")
    private LocalDateTime start;

    @Column(name = "end_at")
    private LocalDateTime end;

    @Column(name = "sales_start")
    private LocalDateTime salesStart;

    @Column(name = "sales_end")
    private LocalDateTime salesEnd;



//  ###################################################
//  #               RelationShips                     #
//  ###################################################

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "organizer_id")
    private User organizer;

    @ManyToMany(mappedBy = "attendingEvents")
    private List<User> attendees = new ArrayList<>();

    @ManyToMany(mappedBy = "staffingEvents")
    private List<User> staff = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<TicketType> ticketTypes = new ArrayList<>();

}
