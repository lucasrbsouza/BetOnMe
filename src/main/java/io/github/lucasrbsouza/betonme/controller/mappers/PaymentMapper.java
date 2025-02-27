package io.github.lucasrbsouza.betonme.controller.mappers;

import io.github.lucasrbsouza.betonme.controller.dto.PaymentDTO;
import io.github.lucasrbsouza.betonme.controller.dto.PaymentResponseDTO;
import io.github.lucasrbsouza.betonme.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "challenge.id", source = "dto.idDesafio", qualifiedByName = "stringToUUID")
    @Mapping(target = "user.id", source = "dto.idUser", qualifiedByName = "stringToUUID")
    @Mapping(target = "valorPagamento", source = "dto.valorPagamento")
    Payment toEntity(PaymentDTO dto);

    @Mapping(target = "responseDTO", source = "payment.challenge")
    @Mapping(target = "userDTO", source = "payment.user")
    @Mapping(target = "valorPagamento", source = "payment.valorPagamento")
    PaymentResponseDTO toDTO(Payment payment);


    @Named("stringToUUID")
    static UUID stringToUUID(String id) {
        return id != null ? UUID.fromString(id) : null;
    }
}
