package com.dbserver.desafio_votacao.service;

import com.dbserver.desafio_votacao.entity.Pauta;
import com.dbserver.desafio_votacao.repository.PautaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class PautaService {

    private final PautaRepository pautaRepository;

    public CompletableFuture<Pauta> salvarPauta(Pauta pauta) {
        return CompletableFuture.supplyAsync(() -> pautaRepository.save(pauta));
    }

    public Optional<Pauta> obterPautaPorId(String id) {
        return pautaRepository.findById(id);
    }
}
