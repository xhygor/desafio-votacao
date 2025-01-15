package com.dbserver.desafio_votacao.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serial;
import java.io.Serializable;

import static com.dbserver.desafio_votacao.util.UuidUtil.generateUuid;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pauta implements Serializable {

    @Serial
    private static final long serialVersionUID = 2472159301892931259L;

    @Id
    @Column(length = 32, nullable = false, unique = true, updatable = false)
    private String id;

    @Column(length = 500, nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String assunto;

    @PrePersist
    private void prePersistConfigs() {
        if (this.id == null) {
            this.id = generateUuid();
        }
    }
}