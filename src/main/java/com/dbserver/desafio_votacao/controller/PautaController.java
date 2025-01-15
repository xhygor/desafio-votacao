package com.dbserver.desafio_votacao.controller;

import com.dbserver.desafio_votacao.entity.Pauta;
import com.dbserver.desafio_votacao.service.PautaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${controllers.pauta.pauta-v1.path}")
@Tag(name = "Pauta", description = "Operações relativas a pauta")
public class PautaController {

    private final PautaService pautaService;

    @PostMapping
    public CompletableFuture<ResponseEntity<Pauta>> criarPauta(@RequestBody Pauta pauta) {
        return pautaService.salvarPauta(pauta)
                .thenApply(savedPauta -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(savedPauta));
    }

    @GetMapping("/{id}")
    public Optional<Pauta> obterPautaPorId(@PathVariable String id) {
        return pautaService.obterPautaPorId(id);
    }
}
