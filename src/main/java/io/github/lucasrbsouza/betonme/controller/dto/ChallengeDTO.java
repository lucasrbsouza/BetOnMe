package io.github.lucasrbsouza.betonme.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.lucasrbsouza.betonme.entity.enuns.StatusDesafio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record ChallengeDTO(

        String titulo,
        String descricao,
        BigDecimal valorAposta,
        @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
        LocalDate dataLimite,
        StatusDesafio statusDesafio,
        String idUser,
        List<String> idFiscais
) {
}
