package com.vadim.server.entity;

import com.vadim.server.entity.enums.UserRoleEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "forum_user")
public class UserEntity extends AuditableEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(STRING)
    @Column(name = "role")
    private UserRoleEntity role;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "icon_url")
    private String iconUrl;
}
