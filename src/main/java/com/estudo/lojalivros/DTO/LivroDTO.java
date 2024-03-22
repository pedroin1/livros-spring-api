package com.estudo.lojalivros.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record LivroDTO(

        Long codigo,

        @NotNull(message = "O codigo do autor é obrigatório")
        @Positive(message = "O codigo do autor deve ser um numero")
        Long codigoAutor,

        @NotBlank(message = "O nome do livro é obrigatório")
        String nome,

        @NotBlank(message = "O nome do livro é obrigatório")
        String nomePublicado,

        @NotNull(message = "A quantidade de paginas do livro é obrigatória")
        @Min(value = 1, message = "A quantidade de paginas do livro deve ser maior que 1")
        int paginas,

        @NotNull(message = "A quantidade de capitulos do livro é obrigatório")
        @Min(value = 1, message = "A quantidade de capitulos do livro deve ser maior que 1")
        int capitulos

) {
}
