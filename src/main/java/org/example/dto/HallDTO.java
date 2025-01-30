package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.entity.CinemaEntity;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HallDTO {
    private Long idHall;
    @NotBlank
    private String nameHall;
    @NotNull
    private Integer hallCapacity;
    @NotNull
    private Long idCinema;
}
