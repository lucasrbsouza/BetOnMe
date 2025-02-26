package io.github.lucasrbsouza.betonme.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;

public record UserDTO(
        @NotBlank
        @Size(min = 2, max = 150, message = "O campo nome deve ter entre 2 e 150 caracteres")
        String nome,

        @NotBlank
        @Email
        String email,

        @NotNull
        String senha
) {
}
