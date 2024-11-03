package com.grupo7.proyectoda.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "estados")
@EntityListeners(AuditingEntityListener.class)
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;
}
