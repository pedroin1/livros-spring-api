package com.estudo.lojalivros.exception;

import com.estudo.lojalivros.model.ResponseResult;
import com.estudo.lojalivros.util.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GenericException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseResult> handleAnyException(Exception exception){

        ResponseResult resultError = new ResponseResult();
        String errorDescription = exception.getLocalizedMessage();
        if(errorDescription == null) errorDescription = exception.toString();

        GenericErroMessage errorMessage = new GenericErroMessage(
                DateUtil.ConvertLocalDateTimeToStringFormatBR(LocalDateTime.now()),
                errorDescription,
                exception.getClass().getSimpleName(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );

        resultError.error(errorMessage);
        return new ResponseEntity<>(resultError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseResult> handleValidationExceptions(MethodArgumentNotValidException exception) {
        ResponseResult resultError = new ResponseResult();
        Map<String, String> errorsMessage = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorsMessage.put(fieldName, errorMessage);
        });

        GenericErroMessage errorMessage = new GenericErroMessage(
                DateUtil.ConvertLocalDateTimeToStringFormatBR(LocalDateTime.now()),
                errorsMessage,
                exception.getClass().getSimpleName(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );

        resultError.error(errorMessage);
        return new ResponseEntity<>(resultError, HttpStatus.BAD_REQUEST);
    }
}