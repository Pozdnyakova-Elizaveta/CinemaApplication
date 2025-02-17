package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"Street\"", schema = "public")
public class StreetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_Street\"")
    private Long idStreet;
    @Column(name = "\"Street_name\"")
    private String streetName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "\"ID_City\"")
    private CityEntity cityEntity;
}
