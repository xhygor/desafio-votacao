package com.dbserver.desafio_votacao.repository;

import com.dbserver.desafio_votacao.entity.Associado;
import com.dbserver.desafio_votacao.util.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends BaseRepository<Associado, String> {
}
