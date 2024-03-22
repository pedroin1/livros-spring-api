package com.estudo.lojalivros.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public record AutorDTO(


        Long codigo,

        @NotBlank(message = "O nome do autor é obrigatório.")
        String nome,

        @Min(value = 1, message = "A idade deve ser um número acima de 0")
        @Max(value = 100, message = "A idade do autor é inválida.")
        int idade,

        @Email(message = "Email do autor esta com formato inválido")
        String email
) {
}
