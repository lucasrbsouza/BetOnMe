package io.github.lucasrbsouza.betonme.controller;

import io.github.lucasrbsouza.betonme.controller.dto.UserDTO;
import io.github.lucasrbsouza.betonme.controller.mappers.UserMapper;
import io.github.lucasrbsouza.betonme.entity.User;
import io.github.lucasrbsouza.betonme.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl service;
    private final UserMapper mapper;

    @PostMapping
    public ResponseEntity<?> salvar(@Valid @RequestBody UserDTO dto) {

        User user = mapper.toEntity(dto);
        service.salvarUser(user);

        UUID id = user.getId();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> buscarPorID(@PathVariable("id") String id) {
        UUID idUser = UUID.fromString(id);

       return service.buscarUserPorId(idUser).map(user -> {
            UserDTO dto = mapper.toDto(user);
            return ResponseEntity.ok(dto);
        }).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") String id, @Valid @RequestBody UserDTO dto){
        UUID idUser = UUID.fromString(id);
        Optional<User> user = service.buscarUserPorId(idUser);

        if (user.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        User user1 = user.get();

        user1.setNome(dto.nome());
        user1.setEmail(dto.email());
        user1.setSenha(dto.senha());

        service.atualizarUser(user1);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id){
        UUID idUser = UUID.fromString(id);

        if (idUser == null){
            return ResponseEntity.badRequest().build();
        }
        service.deleterUser(idUser);

        return ResponseEntity.noContent().build();
    }
}