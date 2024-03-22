package com.estudo.lojalivros.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class GenericErroMessage {

   private String currentDate;
   private String typeErro;
   private Integer statusCode;

   @JsonInclude(JsonInclude.Include.NON_NULL)
   private String erroMessage;

   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   Map<String, String> errosMessage = new HashMap<>();

   public GenericErroMessage(String currentDate, String erroMessage, String typeErro, Integer statusCode){
      this.currentDate = currentDate;
      this.erroMessage = erroMessage;
      this.typeErro = typeErro;
      this.statusCode = statusCode;
   }

   public GenericErroMessage(String currentDate, Map<String, String> errosMessage, String typeErro, Integer statusCode){
      this.currentDate = currentDate;
      this.errosMessage = errosMessage;
      this.typeErro = typeErro;
      this.statusCode = statusCode;
   }


}