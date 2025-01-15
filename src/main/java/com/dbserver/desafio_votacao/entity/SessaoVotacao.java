package com.dbserver.desafio_votacao.entity;

import com.dbserver.desafio_votacao.entity.enums.StatusSessaoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import static com.dbserver.desafio_votacao.util.UuidUtil.generateUuid;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SessaoVotacao implements Serializable {

    @Serial
    private static final long serialVersionUID = 7041604241552151918L;
    private static final long TEMPO_DEFAULT = 60L;

    @Id
    @Column(length = 32, nullable = false, unique = true, updatable = false)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusSessaoEnum status;

    @Column(nullable = false)
    private Long duracao;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private LocalDateTime dataFim;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pauta_id", nullable = false)
    private Pauta pauta;

    @ManyToMany
    @JoinTable(
            name = "sessao_associados",
            joinColumns = @JoinColumn(name = "sessao_id"),
            inverseJoinColumns = @JoinColumn(name = "associado_id")
    )
    private List<Associado> associadosPauta;

    @PrePersist
    private void prePersistConfigs() {
        if (this.id == null) {
            this.id = generateUuid();
        }
        if (this.duracao == null){
            this.duracao = TEMPO_DEFAULT;
        }
        if (this.dataFim == null){
            this.dataFim = dataInicio.plusSeconds(this.duracao);
        }
    }
}
