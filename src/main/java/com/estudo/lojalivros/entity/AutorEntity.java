package com.estudo.lojalivros.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tb_autor")
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor", nullable = false)
    private Long codigo;

    @Column(name = "nome",nullable = false)
    private String nome;

    @Column(name = "idade",nullable = false)
    private int idade;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "autor")
    private Set<LivroEntity> livros;
}