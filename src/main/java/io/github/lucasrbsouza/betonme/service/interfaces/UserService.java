package io.github.lucasrbsouza.betonme.service.interfaces;

import io.github.lucasrbsouza.betonme.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User salvarUser(User user);
    Optional<User> buscarUserPorId(UUID id);
    List<User> buscarTodos();
    User atualizarUser(User user);
    void deleterUser(UUID id);

}
