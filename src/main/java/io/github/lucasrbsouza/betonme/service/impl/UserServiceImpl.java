package io.github.lucasrbsouza.betonme.service.impl;

import io.github.lucasrbsouza.betonme.entity.User;
import io.github.lucasrbsouza.betonme.repository.UserRepository;
import io.github.lucasrbsouza.betonme.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public User salvarUser(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> buscarUserPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<User> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public User atualizarUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleterUser(UUID id) {
        repository.deleteById(id);
    }
}
