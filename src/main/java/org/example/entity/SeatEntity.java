package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"Seat\"", schema = "public")
public class SeatEntity {
    @EmbeddedId
    private SeatId seatId;
    @ManyToOne(fetch = FetchType.EAGER)
    private TypeSeatEntity typeSeatEntity;
}