package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDTO {
    private Long idCinema;
    @NotBlank
    private String nameCinema;
    @NotBlank
    private Integer houseNumber;
    @NotBlank
    private Double latitude;
    @NotBlank
    private Double longitude;
    private Long idStreet;
    private String nameStreet;
}
