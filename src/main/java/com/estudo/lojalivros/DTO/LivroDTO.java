package com.estudo.lojalivros.DTO;

import lombok.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class LivroDTO {

    private Long id;

    @NotNull(message = "{notnull.message}")
    @NotEmpty(message = "{notempty.message}")
    private String nome;

    @NotNull(message = "{notnull.message}")
    @NotEmpty(message = "{notempty.message}")
    private String nomePublicado;

    @NotNull(message = "{notnull.message}")
    @Min(1)
    private int paginas;

    @NotNull(message = "{notnull.message}")
    @Min(1)
    private int capitulos;

    @NotNull(message = "{notnull.message}")
    private AutorDTO autor;
}
