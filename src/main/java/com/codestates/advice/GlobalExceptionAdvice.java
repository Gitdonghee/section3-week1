package com.codestates.advice;

import com.codestates.exception.BusinessLogicException;
import com.codestates.response.v1.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;


@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(
            ConstraintViolationException e){
        final ErrorResponse response = ErrorResponse.of(e.getConstraintViolations());
        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e){
        final ErrorResponse response = ErrorResponse.of(e.getBindingResult());

          return response;
    }


    @ExceptionHandler
    public ResponseEntity handleBusinessLogicException(BusinessLogicException e){
        System.out.println(e.getExceptionCode().getStatus());
        System.out.println(e.getMessage());

        return new ResponseEntity<>(HttpStatus.valueOf(e.getExceptionCode().getStatus()));
    }
}
