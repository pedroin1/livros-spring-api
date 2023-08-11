package com.estudo.lojalivros.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GenericErroMessage {

   private String currentDate;
   private String message;
   private String typeErro;

}