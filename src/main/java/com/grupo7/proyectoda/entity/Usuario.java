package com.grupo7.proyectoda.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "usuarios")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "alias", length = 50, nullable = false)
    private String alias;

    @Column(name = "email", length = 150, nullable = false)
    private String email;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "avatar", length = 255)
    private String avatar;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarea> tareas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Categoria> categorias;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
}
