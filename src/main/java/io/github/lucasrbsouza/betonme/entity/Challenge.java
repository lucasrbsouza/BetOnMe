package io.github.lucasrbsouza.betonme.entity;

import io.github.lucasrbsouza.betonme.entity.enuns.StatusDesafio;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_challenge")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String titulo;
    private String descricao;
    @Column(name = "valor_aposta")
    private BigDecimal valorAposta;
    @Column(name = "data_limite")
    private LocalDate dataLimite;
    @Column(name = "status_deafio")
    @Enumerated(EnumType.STRING)
    private StatusDesafio statusDesafio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToMany
    @JoinTable(name = "challenge_fiscais", joinColumns = @JoinColumn(name = "id_challenge"), inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> fiscais;

    @OneToOne(mappedBy = "challenge")
    @JoinColumn(name = "id_pagamento")
    private Payment pagamento;
}
