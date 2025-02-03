package org.example.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TicketPriceId {
    @ManyToOne(fetch = FetchType.LAZY)
    private SessionEntity sessionEntity;
    @ManyToOne(fetch = FetchType.EAGER)
    private TypeSeatEntity typeSeatEntity;
}