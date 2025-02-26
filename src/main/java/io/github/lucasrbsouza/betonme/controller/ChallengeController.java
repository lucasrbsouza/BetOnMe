package io.github.lucasrbsouza.betonme.controller;

import io.github.lucasrbsouza.betonme.controller.dto.ChallengeDTO;
import io.github.lucasrbsouza.betonme.controller.dto.ChallengeResponseDTO;
import io.github.lucasrbsouza.betonme.controller.exception.ResourceNotFoundException;
import io.github.lucasrbsouza.betonme.controller.mappers.ChallengeMapper;
import io.github.lucasrbsouza.betonme.entity.Challenge;
import io.github.lucasrbsouza.betonme.entity.User;
import io.github.lucasrbsouza.betonme.service.interfaces.ChallengeService;
import io.github.lucasrbsouza.betonme.service.interfaces.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/challenge")
@RequiredArgsConstructor
public class ChallengeController {
    private final ChallengeService service;
    private final UserService userService;
    private final ChallengeMapper mapper;

    @PostMapping
    public ResponseEntity<?> salvar(@Valid @RequestBody ChallengeDTO dto) {
        Optional<User> user = userService.buscarUserPorId(UUID.fromString(dto.idUser()));
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuário com ID " + dto.idUser() + " não encontrado");
        }

        Challenge challengeEntity = mapper.toEntity(dto);
        challengeEntity.setUser(user.get());
        Challenge challenge = service.salvarChallenge(challengeEntity);

        UUID idChallenge = challenge.getId();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idChallenge}").buildAndExpand(idChallenge).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChallengeResponseDTO> buscarPorId(@PathVariable("id") String id) {
        Challenge challenge = service.buscarChallengePorId(UUID.fromString(id))
                .orElseThrow(() -> new ResourceNotFoundException("Desafio não encontrado"));
        ChallengeResponseDTO dto = mapper.toDto(challenge);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ChallengeResponseDTO>> buscarTodos() {
        List<Challenge> challenges = service.buscarTodos();
        if (challenges.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List<ChallengeResponseDTO> responseDTOS = challenges.stream().map(mapper::toDto).toList();
        return ResponseEntity.ok(responseDTOS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") String id, @Valid @RequestBody ChallengeDTO dto) {
        UUID idChallenge = UUID.fromString(id);
        Challenge challenge = service.buscarChallengePorId(idChallenge)
                .orElseThrow(() -> new ResourceNotFoundException("Desafio não encontrado"));

        challenge.setTitulo(dto.titulo());
        challenge.setDescricao(dto.descricao());
        challenge.setValorAposta(dto.valorAposta());
        challenge.setStatusDesafio(dto.statusDesafio());

        service.atualizarChallenge(challenge);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        UUID idChallenge = UUID.fromString(id);
        service.deleterChallenge(idChallenge);
        return ResponseEntity.noContent().build();
    }
}