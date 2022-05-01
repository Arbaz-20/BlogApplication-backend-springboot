package com.arbaz.blog.Exceptions;


import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class PropertyResponseException extends RuntimeException{

    public PropertyResponseException(String error) {
        super(String.format("%s Not found !!!!",error));
    }
}
