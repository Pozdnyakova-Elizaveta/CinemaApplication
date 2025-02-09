package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"City\"", schema = "public")
public class CityEntity {
    @Id
    @Column(name = "\"ID_City\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCity;
    @Column(name = "\"City_Name\"", unique = true, nullable = false, length = 50)
    private String nameCity;
}
