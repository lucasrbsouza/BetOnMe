package io.github.lucasrbsouza.betonme.repository;

import io.github.lucasrbsouza.betonme.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
