package io.github.lucasrbsouza.betonme.service.impl;

import io.github.lucasrbsouza.betonme.controller.PaymentController;
import io.github.lucasrbsouza.betonme.entity.Payment;
import io.github.lucasrbsouza.betonme.repository.PaymentRepository;
import io.github.lucasrbsouza.betonme.service.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;
    @Override
    public Payment salvarPayment(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Optional<Payment> buscarPaymentPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Payment> buscarTodos() {
        return List.of();
    }

    @Override
    public Payment atualizarPayment(Payment payment) {
        return null;
    }

    @Override
    public void deleterPayment(UUID id) {
        repository.deleteById(id);
    }
}
