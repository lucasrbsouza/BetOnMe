package io.github.lucasrbsouza.betonme.controller.mappers;

import io.github.lucasrbsouza.betonme.controller.dto.ChallengeDTO;
import io.github.lucasrbsouza.betonme.controller.dto.ChallengeResponseDTO;
import io.github.lucasrbsouza.betonme.controller.dto.UserDTO;
import io.github.lucasrbsouza.betonme.entity.Challenge;
import io.github.lucasrbsouza.betonme.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ChallengeMapper {

    ChallengeMapper INSTANCE = Mappers.getMapper(ChallengeMapper.class);

    @Mapping(target = "user.id", source = "dto.idUser", qualifiedByName = "mapStringToUUID")
    @Mapping(target = "fiscais", source = "dto.idFiscais", qualifiedByName = "mapIdsToUsers")
    Challenge toEntity(ChallengeDTO dto);

    @Mapping(target = "dto", source = "challenge.user")
    @Mapping(target = "fiscaisDTO", source = "challenge.fiscais", qualifiedByName = "mapUsersToUserDTOs")
    ChallengeResponseDTO toDto(Challenge challenge);

    // Converter IDs de fiscais (List<String>) para List<User>
    @Named("mapIdsToUsers")
    default List<User> mapIdsToUsers(List<String> ids) {
        return ids != null ? ids.stream()
                .map(id -> {
                    User user = new User();
                    user.setId(UUID.fromString(id)); // Converte String para UUID e atribui ao User
                    return user;
                })
                .collect(Collectors.toList()) : null;
    }

    // Converter String em UUID
    @Named("mapStringToUUID")
    default UUID mapStringToUUID(String id) {
        return id != null ? UUID.fromString(id) : null;
    }

    // Converter List<User> para List<UserDTO>
    @Named("mapUsersToUserDTOs")
    default List<UserDTO> mapUsersToUserDTOs(List<User> users) {
        return users != null ? users.stream()
                .map(user -> new UserDTO(user.getNome(), user.getEmail(), user.getSenha())) // Ajuste conforme UserDTO
                .collect(Collectors.toList()) : null;
    }
}
