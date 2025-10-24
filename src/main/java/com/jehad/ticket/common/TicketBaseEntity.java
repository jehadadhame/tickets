package com.jehad.ticket.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@MappedSuperclass
@SuperBuilder(toBuilder = true)
@Setter
@Getter
@RequiredArgsConstructor
public class TicketBaseEntity {

    //    ###################################################
//    #                    Audits                       #
//    ###################################################
    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
