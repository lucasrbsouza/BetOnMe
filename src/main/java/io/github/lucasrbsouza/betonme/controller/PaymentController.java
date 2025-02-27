package io.github.lucasrbsouza.betonme.controller;

import io.github.lucasrbsouza.betonme.controller.dto.PaymentDTO;
import io.github.lucasrbsouza.betonme.controller.dto.PaymentResponseDTO;
import io.github.lucasrbsouza.betonme.controller.mappers.PaymentMapper;
import io.github.lucasrbsouza.betonme.entity.Payment;
import io.github.lucasrbsouza.betonme.service.interfaces.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService services;
    private final PaymentMapper mapper;

    @PostMapping
    public ResponseEntity<?> salvar(@Valid @RequestBody PaymentDTO dto){
        Payment paymentEntity = mapper.toEntity(dto);
        services.salvarPayment(paymentEntity);

        UUID id = paymentEntity.getId();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<PaymentResponseDTO> buscarPorID(@PathVariable("id") String id){
        UUID idPayment = UUID.fromString(id);
        Optional<Payment> payment = services.buscarPaymentPorId(idPayment);
        if (payment.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        PaymentResponseDTO dto = mapper.toDTO(payment.get());

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String  id){
        UUID idPayment = UUID.fromString(id);
        Optional<Payment> payment = services.buscarPaymentPorId(idPayment);
        if (payment.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Payment payment1 = payment.get();

        services.deleterPayment(payment1.getId());

        return ResponseEntity.noContent().build();
    }
}
