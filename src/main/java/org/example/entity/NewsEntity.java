package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"News\"", schema = "public")
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_News\"")
    private Long idNews;
    @Column(name = "\"News_Date\"", nullable = false)
    private Date newsDate;
    @Column(name = "\"News_Headline\"", nullable = false, length = 150)
    private String newsHeadline;
    @Column(name = "\"News_Text\"", nullable = false)
    private String newsText;
    @Column(name = "\"News_Image\"")
    private String newsImage;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}