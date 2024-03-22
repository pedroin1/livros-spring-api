package com.estudo.lojalivros.model;

import com.estudo.lojalivros.entity.AutorEntity;
import com.estudo.lojalivros.entity.LivroEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class LivroVo {

    private Long codigo;
    private String nome;
    private String nomePublicado;
    private int paginas;
    private int capitulos;
    private String nomeAutor;

    public LivroVo(LivroEntity livroEntity){
        this.codigo = livroEntity.getCodigo();
        this.nome = livroEntity.getNome();
        this.nomePublicado = livroEntity.getNomePublicado();
        this.paginas = livroEntity.getPaginas();
        this.capitulos = livroEntity.getCapitulos();
        this.nomeAutor = getNomeAutor(livroEntity.getAutor());
    }

    private String getNomeAutor(AutorEntity autorEntity) {
        if(Objects.nonNull(autorEntity)){
            return autorEntity.getNome();
        } else return null;
    }
}
