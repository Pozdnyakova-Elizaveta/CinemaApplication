package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"User\"", schema = "public")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_User\"")
    private Long idUser;
    @Column(name = "\"Surname_User\"", length = 40)
    private String surnameUser;
    @Column(name = "\"Name_User\"", length = 40)
    private String nameUser;
    @Column(name = "\"Email\"", length = 100, nullable = false, unique = true)
    private String email;
    @Column(name = "\"Phone_Number\"", length = 12, nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = "\"Password\"", length = 30, nullable = false)
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserRoleEntity userRoleEntity;
}
