package com.pedro.api_transacoes.service;

import com.pedro.api_transacoes.dto.EstatisticaResponse;
import com.pedro.api_transacoes.dto.TransacaoRequest;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.DoubleSummaryStatistics;

@Service
public class TransacaoService {
    private final List<TransacaoRequest> listaTransacoes = Collections.synchronizedList(new ArrayList<>());

    public void salvar(TransacaoRequest transacao) {
        listaTransacoes.add(transacao);
    }

    public void limparTransacoes() {
        listaTransacoes.clear();
    }

    public EstatisticaResponse calcularEstatistica() {
        OffsetDateTime tempoLimite = OffsetDateTime.now().minusSeconds(60);

        DoubleSummaryStatistics stats = listaTransacoes.stream()
                .filter(t -> t.dataHora().isAfter(tempoLimite))
                .mapToDouble(TransacaoRequest::valor)
                .summaryStatistics();

        if (stats.getCount() == 0) {
            return new EstatisticaResponse(0L, 0.0, 0.0, 0.0, 0.0);
        }

        return new EstatisticaResponse(
                stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getMin(),
                stats.getMax()
        );
    }
}