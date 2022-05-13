package com.arbaz.blog.Configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class GlobalConfiguration {

    @Bean
    public ModelMapper modelMapper(){

        //Returning the ModelMapper Object to make the binding of the objects from one to another object
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        //Returning the CCryptPasswordEncoder's Bean to the Dependency Injection
        return new BCryptPasswordEncoder();
    }

}
