package com.arbaz.blog.Exceptions;

import com.arbaz.blog.DTO.APIResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

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

    @ExceptionHandler(StringIndexOutOfBoundsException.class)
    public ResponseEntity<APIResponse> stringIndexOutOfBoundException(StringIndexOutOfBoundsException stringIndexOutOfBoundsException){
        String message = "Please Select an Image to Upload";
        APIResponse apiResponse = new APIResponse(message,false);
        return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<APIResponse> multipartException(MultipartException multipartException){
        String message = "Please Select an Image to Upload";
        APIResponse apiResponse = new APIResponse(message,false);
        return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<APIResponse> malformedJwtException(MalformedJwtException malformedJwtException){
        String error = malformedJwtException.getMessage();
        APIResponse apiResponse = new APIResponse(error,false);
        return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<APIResponse> expiredJWTException(ExpiredJwtException expiredJwtException){
        String error = expiredJwtException.getMessage();
        APIResponse apiResponse = new APIResponse(error,false);
        return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.FORBIDDEN);
    }

}
