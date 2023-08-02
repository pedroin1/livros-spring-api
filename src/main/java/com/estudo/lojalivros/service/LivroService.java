package com.estudo.lojalivros.service;

import com.estudo.lojalivros.dto.LivroDTO;
import com.estudo.lojalivros.entity.LivroEntity;
import com.estudo.lojalivros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroDTO> listarLivros() {
        List<LivroEntity> livrosEntity = livroRepository.findAll();
        return livrosEntity.stream().map(LivroDTO::new).collect(Collectors.toList());
    }
}
