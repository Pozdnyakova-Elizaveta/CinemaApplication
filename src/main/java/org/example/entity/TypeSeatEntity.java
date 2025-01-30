package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"Type_Seat\"", schema = "public")
public class TypeSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_Type_Seat\"")
    private Long idTypeSeat;
    @Column(name = "\"Name_Type_Seat\"", unique = true, length = 30, nullable = false)
    private String nameTypeSeat;

}
