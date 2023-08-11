package com.estudo.lojalivros.DTO;

import com.estudo.lojalivros.entity.AutorEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class AutorDTO {

    @NotNull(message = "{notnull.message}")
    @NotEmpty(message = "{notempty.message}")
    private String nome;

    @Positive(message = "{positive.message}")
    private int idade;

    @Email(message = "{email.message}")
    private String email;
}
