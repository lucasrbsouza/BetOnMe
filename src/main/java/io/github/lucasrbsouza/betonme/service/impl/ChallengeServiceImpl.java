package io.github.lucasrbsouza.betonme.service.impl;

import io.github.lucasrbsouza.betonme.entity.Challenge;
import io.github.lucasrbsouza.betonme.entity.User;
import io.github.lucasrbsouza.betonme.repository.ChallengeRepository;
import io.github.lucasrbsouza.betonme.repository.UserRepository;
import io.github.lucasrbsouza.betonme.service.interfaces.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {
    private final ChallengeRepository repository;
    private final UserServiceImpl userService;

    @Override
    @Transactional
    public Challenge salvarChallenge(Challenge challenge) {
        return repository.save(challenge);
    }

    @Override
    public Optional<Challenge> buscarChallengePorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Challenge> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Challenge atualizarChallenge(Challenge challenge) {
        return repository.save(challenge);
    }

    @Override
    public void deleterChallenge(UUID id) {
        repository.deleteById(id);
    }
}
