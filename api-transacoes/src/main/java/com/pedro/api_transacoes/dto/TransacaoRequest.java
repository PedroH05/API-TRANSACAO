package com.pedro.api_transacoes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public record TransacaoRequest(
        @JsonProperty("valor") Double valor,
        @JsonProperty("dataHora") OffsetDateTime dataHora
) {}
