package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDTO {
    private Long idRole;
    @NotBlank
    private String nameRole;
}
