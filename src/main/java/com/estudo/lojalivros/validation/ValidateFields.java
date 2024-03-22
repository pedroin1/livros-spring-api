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
            throw new RuntimeException("Este livro ja existe!");
        }
    }

    public void notExistLivroByNome(String nomeLivro){
        boolean existLivro = repository.existsByNome(nomeLivro);
        if(!existLivro){
            throw new RuntimeException("Este livro não existe!");
        }
    }

    public void existAutorByCodigo(Long codigoAutor) {
        boolean existAutor = autorRepository.existsByCodigo(codigoAutor);
        if(!existAutor){
            throw new RuntimeException("Não existe autor para o codigo fornecido!");
        }
    }

    public void existAutorByNome(String nomeAutor){
        boolean existAutor = autorRepository.existsByNome(nomeAutor);
        if(!existAutor){
            throw new RuntimeException("Não existe autor com este nome!");
        }
    }

    public void validateCreateNewLivro(LivroDTO livroDto){
        existLivroByNome(livroDto.nome());
        existAutorByNome(livroDto.nomeAutor());
    }

    public void validateUpdateLivro(LivroDTO livroDto){
        notExistLivroByNome(livroDto.nome());
        existAutorByNome(livroDto.nomeAutor());
    }
}
