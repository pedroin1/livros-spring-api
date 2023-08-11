package com.estudo.lojalivros.model;

import com.estudo.lojalivros.entity.AutorEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorVo {

    private String nome;
    private int idade;
    private String email;

    public AutorVo (AutorEntity autorEntity){
        this.nome = autorEntity.getNome();
        this.idade = autorEntity.getIdade();
        this.email = autorEntity.getEmail();
    }
}
