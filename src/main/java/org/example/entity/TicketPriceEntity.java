package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"Ticket_Price\"", schema = "public")
public class TicketPriceEntity {
    @EmbeddedId
    private TicketPriceId ticketPriceId;
    @Column(name = "\"Price\"", nullable = false)
    private BigDecimal price;
}
