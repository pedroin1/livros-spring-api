package com.estudo.lojalivros.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "tb_autor")
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor", nullable = false)
    private Long id;

    @Column(name = "nome",nullable = false)
    private String nome;

    @Column(name = "idade",nullable = false)
    private Integer idade;

    @OneToMany(mappedBy = "autor")
    Set<LivroEntity> livros;

    public void setId(Long id) {

    }
}