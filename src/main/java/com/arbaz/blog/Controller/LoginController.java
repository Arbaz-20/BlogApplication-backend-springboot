package com.arbaz.blog.Controller;

import com.arbaz.blog.DTO.APIResponse;
import com.arbaz.blog.DTO.JwtAuthRequest;
import com.arbaz.blog.Utils.JwtAuthenticationResponse;
import com.arbaz.blog.Utils.JwtTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    //Method for Login
    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> CreateToken(@RequestBody JwtAuthRequest request){
        this.Authenticate(request.getEmail(),request.getPassword());

        //Getting the userDetails by loadUserByUsername
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getEmail());

        //Generate Token Using the userDetails
        String token = this.jwtTokenHelper.generateToken(userDetails);

        //Method to response the Authenticated Response
        JwtAuthenticationResponse authenticationResponse = new JwtAuthenticationResponse();
        authenticationResponse.setToken(token);
        return new ResponseEntity<JwtAuthenticationResponse>(authenticationResponse,HttpStatus.ACCEPTED);
    }



    //Method to Authenticate the UserName and Password
    private void Authenticate(String username,String password){

        try{
            //Authenticating the UserName and Password
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);

            //Method to authenticate the token
            this.authenticationManager.authenticate(authenticationToken);

        }catch (DisabledException e){
            new ResponseEntity<>(new APIResponse(e.getMessage(),false),HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
