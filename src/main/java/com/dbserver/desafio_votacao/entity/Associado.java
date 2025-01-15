package com.dbserver.desafio_votacao.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;

import static com.dbserver.desafio_votacao.util.UuidUtil.generateUuid;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Associado implements Serializable {

    @Serial
    private static final long serialVersionUID = -6519076880465250096L;

    @Id
    @Column(length = 32, nullable = false, unique = true, updatable = false)
    private String id;

    @Column(length = 500, nullable = false)
    private String nome;

    @CPF
    @Column(nullable = false)
    private String cpf;

    @PrePersist
    private void prePersistConfigs() {
        if (this.id == null) {
            this.id = generateUuid();
        }
    }
}
