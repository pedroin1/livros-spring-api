package com.estudo.lojalivros.controller;

import com.estudo.lojalivros.dto.LivroDTO;
import com.estudo.lojalivros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value="/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/listar")
    public @ResponseBody ResponseEntity<Object> listarLivros() throws Exception {
        List<LivroDTO> livros = livroService.listarLivros();
        return ResponseEntity.ok(livros);
    }

}
