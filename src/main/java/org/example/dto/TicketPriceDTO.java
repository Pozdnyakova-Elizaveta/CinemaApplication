package org.example.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketPriceDTO {
    @NotNull
    private Long idSession;
    @NotNull
    private Long idHall;
    @NotNull
    private BigDecimal price;
}
