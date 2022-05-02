package com.arbaz.blog.Exceptions;

import com.arbaz.blog.DTO.APIResponse;
import org.hibernate.MappingException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        String message = resourceNotFoundException.getMessage();
        APIResponse apiResponse = new APIResponse(message,false);
        return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        Map<String,String> errors = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName,message);
        });
        return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropertyResponseException.class)
    public ResponseEntity<APIResponse> propertyResponseExceptionResponseEntity(PropertyResponseException propertyResponseException){
        String message = propertyResponseException.getMessage();
        APIResponse apiResponse = new APIResponse(message,false);
        return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.BAD_REQUEST);
    }
}
