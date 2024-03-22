package com.estudo.lojalivros.controller;

import com.estudo.lojalivros.DTO.LivroDTO;
import com.estudo.lojalivros.model.ResponseResult;
import com.estudo.lojalivros.service.LivroService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping(value = "/listar")
    public @ResponseBody ResponseEntity<ResponseResult> getLivros() throws Exception {
        ResponseResult response = service.listAllLivros();
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/criar")
    public @ResponseBody ResponseEntity<ResponseResult> createLivro(@Valid @RequestBody LivroDTO livroDto){
        ResponseResult result = service.createLivro(livroDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/atualizar")
    public @ResponseBody ResponseEntity<ResponseResult> updateLivro(@Valid @RequestBody LivroDTO livroDto){
        ResponseResult result = service.updateLivro(livroDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/remover")
    public @ResponseBody ResponseEntity<ResponseResult> updateLivro(@RequestBody ObjectNode bodyParam){
        Long codigoLivro = bodyParam.get("codigoLivro").asLong();
        ResponseResult result = service.deleteLivro(codigoLivro);
        return ResponseEntity.ok(result);
    }
}
