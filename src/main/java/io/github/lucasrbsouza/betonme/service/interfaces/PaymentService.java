package io.github.lucasrbsouza.betonme.service.interfaces;

import io.github.lucasrbsouza.betonme.entity.Payment;
import io.github.lucasrbsouza.betonme.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentService {
    Payment salvarPayment(Payment payment);
    Optional<Payment> buscarPaymentPorId(UUID id);
    List<Payment> buscarTodos();
    Payment atualizarPayment(Payment payment);
    void deleterPayment(UUID id);

}
