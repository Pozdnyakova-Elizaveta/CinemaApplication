package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"Session\"", schema = "public")
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_Session\"")
    private Long idSession;
    @Column(name = "\"Start_Date_Time\"", nullable = false)
    private LocalDateTime startDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    private MovieEntity movie;
    @ManyToOne(fetch = FetchType.LAZY)
    private HallEntity hall;
}