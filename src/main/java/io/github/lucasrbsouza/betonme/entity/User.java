package io.github.lucasrbsouza.betonme.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String senha;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Payment> pagamentos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Challenge> desafios;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Challenge> fiscaisDoDesafio;
}
