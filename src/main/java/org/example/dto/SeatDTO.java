package org.example.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatDTO {
    @NotNull
    private Integer seatNumber;
    @NotNull
    private Integer Row;
    @NotNull
    private Integer idTypeSeat;
    @NotNull
    private Integer idHall;
}
