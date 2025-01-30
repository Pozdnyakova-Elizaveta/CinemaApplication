package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.dto.SessionDTO;

import java.sql.Date;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"Purchase_Ticket\"", schema = "public")
public class PurchaseTicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_Purchase\"")
    private Long idPurchase;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    private SessionEntity session;
    @ManyToOne(fetch = FetchType.LAZY)
    private HallEntity hall;
    @Column(name = "\"Row\"", nullable = false)
    private Integer row;
    @Column(name = "\"Seat_Number\"", nullable = false)
    private Integer seatNumber;
    @Column(name = "\"Date_Purchase\"", nullable = false)
    private Date datePurchase;
}