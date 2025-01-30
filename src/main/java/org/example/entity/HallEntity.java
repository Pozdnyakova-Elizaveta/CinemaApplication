package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"Hall\"", schema = "public")
public class HallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_Hall\"")
    private Long idHall;
    @Column(name = "\"Name_Hall\"", nullable = false, length = 50)
    private String nameHall;
    @Column(name = "\"Hall_Capacity\"", nullable = false)
    private Integer hallCapacity;
    @ManyToOne(fetch = FetchType.LAZY)
    private CinemaEntity cinema;
}
