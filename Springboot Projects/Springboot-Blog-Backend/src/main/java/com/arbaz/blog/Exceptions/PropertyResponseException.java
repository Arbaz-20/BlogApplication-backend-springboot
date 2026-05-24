package com.arbaz.blog.Exceptions;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Getter
@Setter
public class PropertyResponseException extends RuntimeException{

    public PropertyResponseException(String error) {
        super(String.format("%s Not found !!!!",error));
    }
}
