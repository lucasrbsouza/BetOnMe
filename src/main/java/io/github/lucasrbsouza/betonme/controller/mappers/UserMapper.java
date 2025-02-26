package io.github.lucasrbsouza.betonme.controller.mappers;

import io.github.lucasrbsouza.betonme.controller.dto.UserDTO;
import io.github.lucasrbsouza.betonme.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);
    User toEntity(UserDTO dto);

}
