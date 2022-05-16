package com.arbaz.blog.Controller;

import com.arbaz.blog.DTO.APIResponse;
import com.arbaz.blog.Entity.AuthenticationRequest;
import com.arbaz.blog.Utils.JwtUtil;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<APIResponse> createToken(@RequestBody AuthenticationRequest authenticationRequest){

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getName(),authenticationRequest.getPassword())
            );
        }catch(Exception e){
            return new ResponseEntity<APIResponse>(new APIResponse(e.getMessage(),false),HttpStatus.BAD_REQUEST);

        }
        String token = jwtUtil.generateToken(authenticationRequest.getName());
        return new ResponseEntity(new APIResponse(token,true),HttpStatus.OK);
    }
}
