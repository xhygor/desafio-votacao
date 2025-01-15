package com.dbserver.desafio_votacao.repository;

import com.dbserver.desafio_votacao.entity.SessaoVotacao;
import com.dbserver.desafio_votacao.util.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoVotacaoRepository extends BaseRepository<SessaoVotacao, String> {
}
