package io.github.lucasrbsouza.betonme.entity;

import io.github.lucasrbsouza.betonme.entity.enuns.StatusPagamento;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_payment")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "valor_pagamento")
    private BigDecimal valorPagamento;
    @Column(name = "status_pagamento")
    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_challenge")
    private Challenge challenge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

}
