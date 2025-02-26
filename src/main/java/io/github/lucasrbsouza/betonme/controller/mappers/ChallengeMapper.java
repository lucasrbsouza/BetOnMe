package io.github.lucasrbsouza.betonme.controller.mappers;

import io.github.lucasrbsouza.betonme.controller.dto.ChallengeDTO;
import io.github.lucasrbsouza.betonme.controller.dto.ChallengeResponseDTO;
import io.github.lucasrbsouza.betonme.entity.Challenge;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChallengeMapper {

    @Mapping(target = "user.id", source = "dto.idUser")
    Challenge toEntity(ChallengeDTO dto);

    @Mapping(target = "dto", source = "challenge.user")
    ChallengeResponseDTO toDto(Challenge challenge);


}
