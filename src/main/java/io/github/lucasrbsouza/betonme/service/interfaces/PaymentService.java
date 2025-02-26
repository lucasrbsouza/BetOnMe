package io.github.lucasrbsouza.betonme.service.interfaces;

import io.github.lucasrbsouza.betonme.entity.Payment;
import io.github.lucasrbsouza.betonme.entity.User;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    User salvarPayment(Payment payment);
    Optional<User> buscarPaymentPorId(String id);
    List<User> buscarTodos();
    User atualizarPayment(Payment payment);
    void deleterPayment(String id);

}
