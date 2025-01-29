package org.example.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@Table(name = "\"Movie\"", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {
    @Id
    @Column(name = "\"ID_Movie\"")
    private Long idMovie;
    @Column(name = "\"Movie_Title\"", nullable = false, length = 100)
    private String movieTitle;
    @Column(name = "\"Year_Release\"", nullable = false)
    private Integer yearRelease;
    @Column(name = "\"Raiting_KP\"", nullable = false)
    private Double raitingKP;
    @Column(name = "\"Raiting_IMDB\"")
    private Double raitingIMDB;
    @Column(name = "\"Description_Movie\"", nullable = false)
    private String descriptionMovie;
    @Column(name = "\"Age_Limit\"", nullable = false, length = 3)
    private String ageLimit;
    @Column(name = "\"Country_Origin\"", nullable = false)
    private String countryOrigin;
    @Column(name = "\"Poster\"")
    private String poster;
    @Column(name = "\"Rental_Start_Date\"", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date rentalStartDate;
    @Column(name = "\"Rental_End_Date\"", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date rentalEndDate;
    @Column(name = "\"Movie_Duration\"", nullable = false)
    private Integer movieDuration;
}
