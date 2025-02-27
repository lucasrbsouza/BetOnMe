package io.github.lucasrbsouza.betonme.controller.dto;

import io.github.lucasrbsouza.betonme.entity.enuns.StatusPagamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PaymentDTO(
        @Positive(message = "O valor do pagamento deve ser positivo")
        @NotNull(message = "O valor do pagamento não pode ser nulo")
        BigDecimal valorPagamento,

        @NotNull(message = "O status do pagamento não pode ser nulo")
        StatusPagamento statusPagamento,

        String idDesafio,
        String idUser
) {
}
