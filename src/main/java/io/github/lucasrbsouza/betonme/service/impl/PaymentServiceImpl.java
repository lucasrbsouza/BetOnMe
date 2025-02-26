package io.github.lucasrbsouza.betonme.service.impl;

import io.github.lucasrbsouza.betonme.entity.Payment;
import io.github.lucasrbsouza.betonme.entity.User;
import io.github.lucasrbsouza.betonme.service.interfaces.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public Payment salvarPayment(Payment payment) {
        return null;
    }

    @Override
    public Optional<Payment> buscarPaymentPorId(UUID id) {
        return Optional.empty();
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

    }
}
