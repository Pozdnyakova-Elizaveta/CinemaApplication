package org.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.entity.CityEntity;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StreetDTO {
    private Long idStreet;
    @NotBlank
    private String streetName;
    private Long idCity;
    private String nameCity;
}
