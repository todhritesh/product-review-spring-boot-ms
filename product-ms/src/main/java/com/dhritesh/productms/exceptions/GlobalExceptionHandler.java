package com.dhritesh.productms.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dhritesh.productms.dtos.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler  {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException e) {
        String msg = e.getMessage();
        return new ResponseEntity<>(new ApiResponse(false,msg),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String,String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((err)->{
            
            String fieldName = ((FieldError)err).getField();
            String fieldMsg = err.getDefaultMessage();
            errors.put(fieldName, fieldMsg);
        });
        System.out.println("todo");
        System.out.println(errors);
        return new ResponseEntity<>(new ApiResponse(false,"Validation error",errors),HttpStatus.BAD_REQUEST);
    }
}
