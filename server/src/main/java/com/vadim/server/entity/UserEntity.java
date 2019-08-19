package com.vadim.server.entity;

import com.vadim.server.entity.enums.UserRoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.time.Instant;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@EqualsAndHashCode(callSuper = false)
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

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "name")
    private String name;

    @Enumerated(STRING)
    @Column(name = "role")
    private UserRoleEntity role;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "activation_key", unique = true)
    private UUID activationKey;

    @Column(name = "reset_key", unique = true)
    private UUID resetKey;

    @Column(name = "activated", nullable = false)
    private boolean isActivated;

    @PrePersist
    @Override
    public void prePersist() {
        createdAt = Instant.now();
    }
}
