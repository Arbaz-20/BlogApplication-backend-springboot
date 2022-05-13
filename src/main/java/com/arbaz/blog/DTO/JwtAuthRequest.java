package com.arbaz.blog.DTO;

import lombok.Data;

@Data
public class JwtAuthRequest {

    private String email;

    private String password;
}
