package com.example.crudfarmacia.exception;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.Logger;
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
   @ExceptionHandler(value
           = { IllegalArgumentException.class, IllegalStateException.class })
   protected ResponseEntity<Object> handleConflict(
           RuntimeException ex, WebRequest request) {
      String bodyOfResponse = "This should be application specific";
      return handleExceptionInternal(ex, bodyOfResponse,
              new HttpHeaders(), HttpStatus.CONFLICT, request);
   }
}
