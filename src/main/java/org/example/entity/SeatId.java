package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SeatId {
    @ManyToOne(fetch = LAZY)
    private HallEntity hallEntity;
    @Column(name = "\"Row\"", nullable = false)
    private Integer row;
    @Column(name = "\"Seat_Number\"", nullable = false)
    private Integer seatNumber;
}