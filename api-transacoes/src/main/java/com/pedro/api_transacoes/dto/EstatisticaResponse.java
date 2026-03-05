package com.pedro.api_transacoes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EstatisticaResponse(
        @JsonProperty("count") long count,
        @JsonProperty("sum") Double sum,
        @JsonProperty("avg") Double avg,
        @JsonProperty("min") Double min,
        @JsonProperty("max") Double max
) {}