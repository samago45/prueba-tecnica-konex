package com.example.crudfarmacia.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    //Cuando no se cumple con los argumentos validos del DTO (Data transfer Objet)

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> vhandleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

//    //No se encontro el usuario
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(UserNotFoundException.class)
//    public Map<String, String> handleBusinessException(UserNotFoundException ex) {
//        Map<String, String> errorMap = new HashMap<>();
//        errorMap.put("errorMessage", ex.getMessage());
//        return errorMap;
//    }


    //Errores de peticiones  del controlador
    @ExceptionHandler(value = {ControllerResquestException.class})
    public ResponseEntity<Object> handleControllerException(ControllerResquestException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), e, HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }


}
