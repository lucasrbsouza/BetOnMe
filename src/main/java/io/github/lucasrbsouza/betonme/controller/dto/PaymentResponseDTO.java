package io.github.lucasrbsouza.betonme.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.lucasrbsouza.betonme.entity.enuns.StatusPagamento;

import java.math.BigDecimal;

public record PaymentResponseDTO(
        BigDecimal valorPagamento,
        StatusPagamento statusPagamento,
        @JsonProperty("Desafios")
        ChallengeResponseDTO responseDTO,
        @JsonProperty("User")
        UserDTO userDTO
) {
}
