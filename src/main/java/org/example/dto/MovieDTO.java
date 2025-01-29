package org.example.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Long idMovie;
    @NotBlank
    private String movieTitle;
    @NotNull
    private Integer yearRelease;
    private Double raitingKP;
    private Double raitingIMDB;
    private String descriptionMovie;
    private String ageLimit;
    private String countryOrigin;
    private String poster;
    private Date rentalStartDate;
    private Date rentalEndDate;
    private Integer movieDuration;
}
