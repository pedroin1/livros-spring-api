package com.estudo.lojalivros.controller;

import com.estudo.lojalivros.DTO.LivroDTO;
import com.estudo.lojalivros.model.ResponseResult;
import com.estudo.lojalivros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/listar")
    public @ResponseBody ResponseEntity<ResponseResult> listarLivros() throws Exception {
        ResponseResult response = livroService.listarLivros();
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/criarLivro")
    public @ResponseBody ResponseEntity<ResponseResult> criarLivro(@Valid @RequestBody LivroDTO livroDto, BindingResult bindingResult){
        ResponseResult result = new ResponseResult();

        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream().map(er -> er.getField() + ": " + er.getDefaultMessage()).collect(Collectors.toList());
            result.error("Erro de validação: " + errors);
            return ResponseEntity.badRequest().body(result);
        }
          result = livroService.criarLivro(livroDto);
          return ResponseEntity.ok(result);
    }
}
