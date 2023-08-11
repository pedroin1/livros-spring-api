package com.estudo.lojalivros.exception;

import com.estudo.lojalivros.model.ResponseResult;
import com.estudo.lojalivros.util.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.rmi.CORBA.Util;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GenericException extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value= {Exception.class})
    public ResponseEntity<ResponseResult> handleAnyException(Exception e){

        ResponseResult resultError = new ResponseResult();
        String errorDescription = e.getLocalizedMessage();
        if(errorDescription == null) errorDescription = e.toString();

        GenericErroMessage errorMessage = new GenericErroMessage(
                DateUtil.ConvertLocalDateTimeToStringFormatBR(LocalDateTime.now()),
                errorDescription,
                e.getClass().getSimpleName()
            );

        resultError.error(errorMessage);
        return new ResponseEntity<>(resultError,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}