package com.estudo.lojalivros.controller;

import com.estudo.lojalivros.DTO.AutorDTO;
import com.estudo.lojalivros.DTO.LivroDTO;
import com.estudo.lojalivros.model.ResponseResult;
import com.estudo.lojalivros.service.AutorService;
import com.estudo.lojalivros.service.LivroService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/autor")
public class AutorController {

    @Autowired
    private AutorService service;

    @GetMapping(value = "/listar")
    public @ResponseBody ResponseEntity<ResponseResult> getLivros() throws Exception {
        ResponseResult response = service.listAllautores();
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/criar")
    public @ResponseBody ResponseEntity<ResponseResult> createLivro(@Valid @RequestBody AutorDTO autorDTO){
        ResponseResult result = service.createAutor(autorDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/atualizar")
    public @ResponseBody ResponseEntity<ResponseResult> updateLivro(@Valid @RequestBody AutorDTO autorDTO){
        ResponseResult result = service.updateAutor(autorDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/remover")
    public @ResponseBody ResponseEntity<ResponseResult> updateLivro(@RequestBody ObjectNode bodyParam){
        Long codigoAutor = bodyParam.get("codigoAutor").asLong();
        ResponseResult result = service.deleteAutor(codigoAutor);
        return ResponseEntity.ok(result);
    }
}
