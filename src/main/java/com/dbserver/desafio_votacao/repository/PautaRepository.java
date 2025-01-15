package com.dbserver.desafio_votacao.repository;

import com.dbserver.desafio_votacao.entity.Pauta;
import com.dbserver.desafio_votacao.util.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends BaseRepository<Pauta, String> {
}
