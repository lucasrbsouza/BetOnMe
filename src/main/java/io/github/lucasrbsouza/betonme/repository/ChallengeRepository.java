package io.github.lucasrbsouza.betonme.repository;

import io.github.lucasrbsouza.betonme.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChallengeRepository extends JpaRepository<Challenge, UUID> {
}
