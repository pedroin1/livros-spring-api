package com.estudo.lojalivros.entity;

import com.estudo.lojalivros.DTO.LivroDTO;
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

    public static LivroEntity convertDtoToEntity(LivroDTO livroDto, AutorEntity autorEntity){
        LivroEntity livroEntity = new LivroEntity();
        livroEntity.setNome(livroDto.nome());
        livroEntity.setNomePublicado(livroDto.nomePublicado());
        livroEntity.setPaginas(livroDto.paginas());
        livroEntity.setCapitulos(livroDto.capitulos());
        livroEntity.setAutor(autorEntity);

        return livroEntity;
    }

    public void updateLivro(LivroDTO livroDto, AutorEntity autorEntity) {
        this.nomePublicado = livroDto.nomePublicado();
        this.paginas = livroDto.paginas();
        this.capitulos = livroDto.capitulos();
        this.autor = autorEntity;
    }
}