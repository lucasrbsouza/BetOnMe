package io.github.lucasrbsouza.betonme.repository;

import io.github.lucasrbsouza.betonme.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
