package com.vadim.server.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "post")
public class PostEntity extends AuditableEntity{
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, insertable = false)
    private UUID id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "image_url")
    private String imageUrl;
}
