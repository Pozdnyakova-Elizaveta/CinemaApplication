package org.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.entity.HallEntity;
import org.example.entity.SessionEntity;
import org.example.entity.UserEntity;

import java.sql.Date;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseTicketDTO {
    private Long idPurchase;
    @NotNull
    private Long idUser;
    @NotNull
    private Long idSession;
    @NotNull
    private Long idHall;
    @NotNull
    private Integer row;
    @NotNull
    private Integer seatNumber;
    @NotNull
    private Date datePurchase;
}
