package com.dbserver.desafio_votacao.entity;

import com.dbserver.desafio_votacao.entity.enums.VotoEnum;
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
@Table(
        name = "voto",
        uniqueConstraints = @UniqueConstraint(columnNames = {"associado_id", "sessao_id"})
)
public class Voto implements Serializable {

    @Serial
    private static final long serialVersionUID = 7061092588093187222L;

    @Id
    @Column(length = 32, nullable = false, unique = true, updatable = false)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VotoEnum status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "associado_id", nullable = false)
    private Associado associado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sessao_id", nullable = false)
    private SessaoVotacao sessaoVotacao;

    @PrePersist
    private void prePersistConfigs() {
        if (this.id == null) {
            this.id = generateUuid();
        }
    }
}
