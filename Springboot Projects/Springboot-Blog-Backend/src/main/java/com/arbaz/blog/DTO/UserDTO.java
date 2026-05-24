package com.arbaz.blog.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private int id;

    @NotEmpty(message = "Please Enter Name")
    @NotBlank(message = "Please Enter Name")
    private String name;

    @NotEmpty(message = "Please Enter Password")
    @Size(min = 8,message = "Password must contains 8 characters")
    private String password;

    @NotEmpty(message = "Please Enter Email")
    @Email(regexp = "^(.+)@(\\S+)$",message = "Invalid Email")
    private String email;

    @NotEmpty(message = "Please Enter Something About Yourself")
    @Size(min = 15,message = "Please Enter Something within 10 to 15 words")
    private String about;

    private String role;
}
