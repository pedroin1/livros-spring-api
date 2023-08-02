package com.estudo.lojalivros.dto;

import com.estudo.lojalivros.entity.AutorEntity;
import lombok.Data;

@Data
public class AutorDTO {

    private String nome;
    private int idade;

    public AutorDTO(AutorEntity autorEntity) {
        this.nome = autorEntity.getNome();
        this.idade = autorEntity.getIdade();
    }
}
