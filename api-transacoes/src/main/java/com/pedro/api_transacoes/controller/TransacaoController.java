package com.pedro.api_transacoes.controller;

import com.pedro.api_transacoes.dto.EstatisticaResponse;
import com.pedro.api_transacoes.dto.TransacaoRequest;
import com.pedro.api_transacoes.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @Operation(summary = "Registra uma nova transação")
    @PostMapping("/transacao")
    public ResponseEntity<String> postTransacao(@RequestBody TransacaoRequest request) {
        // Validação simples de negócio
        if (request.valor() < 0 || request.dataHora().isAfter(OffsetDateTime.now())) {
            return ResponseEntity.unprocessableEntity().body("Erro: Dados inválidos.");
        }

        service.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Transação concluída com sucesso!");
    }

    @Operation(summary = "Limpa todas as transações")
    @DeleteMapping("/transacao")
    public ResponseEntity<String> deleteTransacoes() {
        service.limparTransacoes();
        return ResponseEntity.ok().body("Todas as transações foram limpas com sucesso!");
    }

    @Operation(summary = "Calcula estatísticas dos últimos 60 segundos")
    @GetMapping("/estatistica")
    public ResponseEntity<EstatisticaResponse> getEstatisticas() {
        var estatisticas = service.calcularEstatistica();
        return ResponseEntity.ok(estatisticas);
    }
}