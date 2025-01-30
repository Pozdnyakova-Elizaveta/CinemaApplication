package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.entity.UserEntity;

import java.sql.Date;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO {
    private Long idNews;
    @NotNull
    private Date newsDate;
    @NotBlank
    private String newsHeadline;
    @NotBlank
    private String newsText;
    private String newsImage;
    private Long idUser;
}
