package org.example.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionDTO {
    private Long idSession;
    @NotNull
    private Date startDateTime;
    @NotNull
    private Long idMovie;
    @NotNull
    private Long idHall;
}
