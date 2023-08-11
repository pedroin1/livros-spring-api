package com.estudo.lojalivros.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tb_livro")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro", nullable = false)
    private Long codigo;

    @Column(name = "nome",nullable = false)
    private String nome;

    @Column(name = "paginas", nullable = false)
    private Integer paginas;

    @Column(name = "capitulos",nullable = false)
    private Integer capitulos;

    @Column(name = "nome_publicado",nullable = false, unique = true)
    private String nomePublicado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor", nullable=false)
    private AutorEntity autor;
}