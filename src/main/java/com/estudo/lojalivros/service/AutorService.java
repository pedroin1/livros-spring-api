package com.estudo.lojalivros.service;

import com.estudo.lojalivros.DTO.AutorDTO;
import com.estudo.lojalivros.entity.AutorEntity;
import com.estudo.lojalivros.entity.LivroEntity;
import com.estudo.lojalivros.model.AutorVo;
import com.estudo.lojalivros.model.ResponseResult;
import com.estudo.lojalivros.repository.AutorRepository;
import com.estudo.lojalivros.validation.ValidateFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;
    @Autowired
    private ValidateFields validation;

    public ResponseResult listAllautores() {
        ResponseResult responseResult = new ResponseResult();

        List<AutorEntity> autorEntityList = repository.findAll();
        List<AutorVo> autorVoList = convertEntityToVoList(autorEntityList);

        responseResult.success(autorVoList);
        return responseResult;
    }

    public ResponseResult createAutor(AutorDTO autorDTO) {
        ResponseResult responseResult = new ResponseResult();

        AutorEntity autorEntity = AutorEntity.convertDtoToEntity(autorDTO);
        AutorVo autorVo = convertEntityToVo(repository.save(autorEntity));

        responseResult.success(autorVo);
        return responseResult;
    }

    public ResponseResult updateAutor(AutorDTO autorDTO) {
        ResponseResult responseResult = new ResponseResult();

        validation.existAutorByCodigo(autorDTO.codigo());
        AutorEntity autorEntityToSave = repository.findByCodigo(autorDTO.codigo());
        autorEntityToSave.updateAutor(autorDTO);

        AutorEntity updatedAutor = repository.save(autorEntityToSave);
        AutorVo autorVo = convertEntityToVo(updatedAutor);

        responseResult.success(autorVo);
        return responseResult;
    }

    public ResponseResult deleteAutor(Long codigoAutor) {
        ResponseResult responseResult = new ResponseResult();

        validation.existAutorByCodigo(codigoAutor);
        repository.deleteById(codigoAutor);

        responseResult.success("Autor de codigo '" + codigoAutor + "' foi removido com sucesso.");
        return responseResult;
    }

    private AutorVo convertEntityToVo(AutorEntity autorEntity){
        return new AutorVo(autorEntity);
    }

    private List<AutorVo> convertEntityToVoList(List<AutorEntity> autorEntityList){
        return autorEntityList.stream().map(this::convertEntityToVo).toList();
    }
}
