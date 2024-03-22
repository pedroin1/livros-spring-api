package com.estudo.lojalivros.service;

import com.estudo.lojalivros.DTO.LivroDTO;
import com.estudo.lojalivros.entity.AutorEntity;
import com.estudo.lojalivros.entity.LivroEntity;
import com.estudo.lojalivros.model.LivroVo;
import com.estudo.lojalivros.model.ResponseResult;
import com.estudo.lojalivros.repository.AutorRepository;
import com.estudo.lojalivros.repository.LivroRepository;
import com.estudo.lojalivros.validation.ValidateFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private ValidateFields validation;

    public ResponseResult listAllLivros() {
        ResponseResult responseResult = new ResponseResult();

        List<LivroEntity> livrosEntity = repository.findAll();
        List<LivroVo> livrosDTO = convertEntityListToVo(livrosEntity);

        responseResult.success(livrosDTO);
        return responseResult;
    }

    public ResponseResult createLivro(LivroDTO livroDto) {
        ResponseResult responseResult = new ResponseResult();

        validation.validateCreateNewLivro(livroDto);

        AutorEntity autorEntity = autorRepository.findByNome(livroDto.nomeAutor());
        LivroEntity novoLivro = repository.save(LivroEntity.convertDtoToEntity(livroDto, autorEntity));

        responseResult.success(convertEntityToVo(novoLivro));
        return responseResult;
    }

    public ResponseResult updateLivro(LivroDTO livroDto) {
        ResponseResult responseResult = new ResponseResult();

        validation.validateUpdateLivro(livroDto);

        AutorEntity autorEntity = autorRepository.findByNome(livroDto.nomeAutor());
        LivroEntity livroEntityToSave = repository.findByNome(livroDto.nome());
        livroEntityToSave.updateLivro(livroDto, autorEntity);

        LivroEntity savedLivro = repository.save(livroEntityToSave);
        responseResult.success(convertEntityToVo(savedLivro));
        return responseResult;
    }

    public ResponseResult deleteLivro(String nomeLivro) {
        ResponseResult responseResult = new ResponseResult();

        validation.notExistLivroByNome(nomeLivro);
        LivroEntity livroEntity = repository.findByNome(nomeLivro);
        repository.delete(livroEntity);

        responseResult.success("Livro deletado com sucesso");
        return responseResult;
    }

    private LivroVo convertEntityToVo(LivroEntity livroEntity) {
        return new LivroVo(livroEntity);
    }

    private List<LivroVo> convertEntityListToVo(List<LivroEntity> livrosEntity) {
        return livrosEntity.stream().map(this::convertEntityToVo).toList();
    }
}
