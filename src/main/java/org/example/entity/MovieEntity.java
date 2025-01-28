package org.example.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@Table(name = "Movie", schema = "public")
public class MovieEntity {
    @Id
    private Long idMovie;
    @Column(nullable = false, length = 100)
    private String movieTitle;
    @Column(nullable = false)
    private Integer yearRelease;
    @Column(nullable = false)
    private Double raitingKP;
    @Column
    private Double raitingIMDB;
    @Column(nullable = false)
    private String descriptionMovie;
    @Column(nullable = false, length = 3)
    private String ageLimit;
    @Column(nullable = false)
    private String countryOrigin;
    @Column
    private String poster;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date rentalStartDate;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date rentalEndDate;
    @Column(nullable = false)
    private Integer movieDuration;
}
