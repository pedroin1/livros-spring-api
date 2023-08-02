package com.estudo.lojalivros.dto;

import com.estudo.lojalivros.entity.LivroEntity;
import lombok.Data;

@Data
public class LivroDTO {

    private Long id;
    private String nomePublicado;
    private int paginas;
    private int capitulos;
    private AutorDTO autor;

    public LivroDTO(LivroEntity livroEntity) {
        this.id = livroEntity.getId();
        this.nomePublicado = livroEntity.getNomePublicado();
        this.paginas = livroEntity.getPaginas();
        this.capitulos = livroEntity.getCapitulos();
        this.autor = new AutorDTO(livroEntity.getAutor());
    }
}
