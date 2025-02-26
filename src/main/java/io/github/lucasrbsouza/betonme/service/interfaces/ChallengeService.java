package io.github.lucasrbsouza.betonme.service.interfaces;

import io.github.lucasrbsouza.betonme.entity.Challenge;
import io.github.lucasrbsouza.betonme.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChallengeService {
    Challenge salvarChallenge(Challenge challenge);
    Optional<Challenge> buscarChallengePorId(UUID id);
    List<Challenge> buscarTodos();
    Challenge atualizarChallenge(Challenge challenge);
    void deleterChallenge(UUID id);

}
