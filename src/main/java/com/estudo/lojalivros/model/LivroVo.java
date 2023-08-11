package com.estudo.lojalivros.model;

import com.estudo.lojalivros.DTO.AutorDTO;
import com.estudo.lojalivros.entity.AutorEntity;
import com.estudo.lojalivros.entity.LivroEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroVo {

    private String nomePublicado;
    private int paginas;
    private int capitulos;
    private AutorVo autor;

    public LivroVo(LivroEntity livroEntity){
        this.nomePublicado = livroEntity.getNomePublicado();
        this.paginas = livroEntity.getPaginas();
        this.capitulos = livroEntity.getCapitulos();
        this.autor = convertAutorEntityToVo(livroEntity.getAutor());
    }

    private AutorVo convertAutorEntityToVo(AutorEntity autorEntity){
        return new AutorVo(autorEntity);
    }
}
