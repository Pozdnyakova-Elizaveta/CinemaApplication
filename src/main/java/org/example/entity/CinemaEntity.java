package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"Cinema\"", schema = "public")
public class CinemaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_Cinema\"")
    private Long idCinema;
    @Column(name = "\"Name_Cinema\"", nullable = false, length = 100)
    private String nameCinema;
    @Column(name = "\"House_Number\"", nullable = false)
    private Integer houseNumber;
    @Column(name = "\"Longitude\"", nullable = false)
    private Double latitude;
    @Column(name = "\"City_Name\"", nullable = false)
    private Double longitude;
    @ManyToOne(fetch = FetchType.LAZY)
    private StreetEntity street;
}
