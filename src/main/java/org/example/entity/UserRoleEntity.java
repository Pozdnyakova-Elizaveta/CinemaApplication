package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"User_Role\"", schema = "public")
public class UserRoleEntity {
    @Id
    @Column(name = "\"ID_User_Role\"")
    private Long idRole;
    @Column(name = "\"Name_User_Role\"", unique = true, nullable = false, length = 50)
    private String nameRole;

}
