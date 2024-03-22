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

        List<LivroEntity> livroEntityList = repository.findAll();
        List<LivroVo> livroDtoList = convertEntityListToVo(livroEntityList);

        responseResult.success(livroDtoList);
        return responseResult;
    }

    public ResponseResult createLivro(LivroDTO livroDto) {
        ResponseResult responseResult = new ResponseResult();

        validation.validateCreateNewLivro(livroDto);

        AutorEntity autorEntity = autorRepository.findByCodigo(livroDto.codigoAutor());
        LivroEntity newLivroEntity = repository.save(LivroEntity.convertDtoToEntity(livroDto, autorEntity));

        responseResult.success(convertEntityToVo(newLivroEntity));
        return responseResult;
    }

    public ResponseResult updateLivro(LivroDTO livroDto) {
        ResponseResult responseResult = new ResponseResult();

        validation.validateUpdateLivro(livroDto);

        AutorEntity autorEntity = autorRepository.findByCodigo(livroDto.codigoAutor());
        LivroEntity livroEntity = repository.findByCodigo(livroDto.codigo());
        livroEntity.updateLivro(livroDto, autorEntity);

        LivroEntity updatedLivroEntity = repository.save(livroEntity);
        responseResult.success(convertEntityToVo(updatedLivroEntity));
        return responseResult;
    }

    public ResponseResult deleteLivro(Long codigoLivro) {
        ResponseResult responseResult = new ResponseResult();

        validation.existLivroByCodigo(codigoLivro);
        repository.deleteById(codigoLivro);

        responseResult.success("Livro de codigo '" + codigoLivro + "' foi removido com sucesso!");
        return responseResult;
    }

    private LivroVo convertEntityToVo(LivroEntity livroEntity) {
        return new LivroVo(livroEntity);
    }

    private List<LivroVo> convertEntityListToVo(List<LivroEntity> livrosEntity) {
        return livrosEntity.stream().map(this::convertEntityToVo).toList();
    }
}
