package com.dbserver.desafio_votacao.repository;

import com.dbserver.desafio_votacao.entity.Voto;
import com.dbserver.desafio_votacao.util.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends BaseRepository<Voto, String> {
}
