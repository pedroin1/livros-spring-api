package com.estudo.lojalivros.validation;

import com.estudo.lojalivros.DTO.LivroDTO;
import com.estudo.lojalivros.repository.AutorRepository;
import com.estudo.lojalivros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateFields {

    @Autowired
    private LivroRepository repository;
    @Autowired
    private AutorRepository autorRepository;

    public void existLivroByNome(String nomeLivro){
        boolean existLivro = repository.existsByNome(nomeLivro);
        if(existLivro){
            throw new RuntimeException("Já existe livro com este nome!");
        }
    }

    public void existLivroByCodigo(Long codigoLivro){
        boolean existLivro = repository.existsById(codigoLivro);
        if(!existLivro){
            throw new RuntimeException("Não existe livro com este código!");
        }
    }

    public void existAutorByCodigo(Long codigoAutor) {
        boolean existAutor = autorRepository.existsByCodigo(codigoAutor);
        if(!existAutor){
            throw new RuntimeException("Não existe autor com este código!");
        }
    }

    public void validateCreateNewLivro(LivroDTO livroDto){
        existLivroByNome(livroDto.nome());
        existAutorByCodigo(livroDto.codigoAutor());
    }

    public void validateUpdateLivro(LivroDTO livroDto){
        existLivroByCodigo(livroDto.codigo());
        existAutorByCodigo(livroDto.codigoAutor());
    }
}
