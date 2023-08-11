package com.estudo.lojalivros.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenericErroMessage {

   private String currentDate;
   private String message;
   private String typeErro;

}