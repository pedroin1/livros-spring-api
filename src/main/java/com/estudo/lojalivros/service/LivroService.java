package com.estudo.lojalivros.service;

import com.estudo.lojalivros.DTO.LivroDTO;
import com.estudo.lojalivros.entity.AutorEntity;
import com.estudo.lojalivros.entity.LivroEntity;
import com.estudo.lojalivros.model.LivroVo;
import com.estudo.lojalivros.model.ResponseResult;
import com.estudo.lojalivros.repository.AutorRepository;
import com.estudo.lojalivros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public ResponseResult listarLivros() {
        ResponseResult responseResult = new ResponseResult();

        List<LivroEntity> livrosEntity = livroRepository.findAll();
        List<LivroVo> livrosDTO = convertEntityListToVo(livrosEntity);

        responseResult.success(livrosDTO);
        return responseResult;
    }

    public ResponseResult criarLivro(LivroDTO livroDto){
        ResponseResult responseResult = new ResponseResult();

        validNovoLivro(livroDto);
        LivroEntity novoLivro =  livroRepository.save(convertDTOtoEntity(livroDto));

        responseResult.success(convertEntityToVo(novoLivro));
        return responseResult;
    }

    private void validNovoLivro(LivroDTO livroDto){
        LivroEntity novoLivro = livroRepository.findByNome(livroDto.getNome());
        if(novoLivro != null){
            throw new RuntimeException("Este Livro ja existe!");
        }
    }

    private LivroEntity convertDTOtoEntity(LivroDTO livroDto){
        AutorEntity autorEntity = autorRepository.findByNome(livroDto.getAutor().getNome());
        LivroEntity livroEntity = new LivroEntity();
        livroEntity.setNome(livroDto.getNome());
        livroEntity.setNomePublicado(livroDto.getNomePublicado());
        livroEntity.setPaginas(livroDto.getPaginas());
        livroEntity.setCapitulos(livroDto.getCapitulos());
        livroEntity.setAutor(autorEntity);

        return livroEntity;
    }

    private LivroVo convertEntityToVo(LivroEntity livroEntity){
        return new LivroVo(livroEntity);
    }

    private List<LivroVo> convertEntityListToVo(List<LivroEntity> livrosEntity){
        List<LivroVo> livrosVo = new ArrayList<>();

        for(LivroEntity livroEntity: livrosEntity){
            LivroVo livroVo = convertEntityToVo(livroEntity);
            livrosVo.add(livroVo);
        }

        return livrosVo;
    }

}
