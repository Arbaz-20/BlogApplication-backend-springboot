package com.arbaz.blog.Utils;


import com.arbaz.blog.DTO.APIResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String userName = "";
        String token = "";

        //Get Token
        try{

            String requestToken = request.getHeader("Authorization");

            if(requestToken !=null && requestToken.startsWith("Bearer")){

                token = requestToken.substring(7);
                userName = this.jwtTokenHelper.getUserNameFromToken(token);

            }else{
                new ResponseEntity<>(new APIResponse("Invalid Token",false),HttpStatus.BAD_REQUEST);
            }

            //Getting the UserDetails from UserDetailService class
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);

            //Authenticating the Token and the Username Password Details
            if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){

                if(this.jwtTokenHelper.validateToken(token,userDetails)){

                    //Getting Username Password Authentication Token by providing the details of the User using UserDetails
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                    //After passing the details we set the build Details properties by providing the request
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    //Setting the Username Password Authentication Token
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }
        catch (IllegalArgumentException ex){
            new ResponseEntity<>(new APIResponse(ex.getMessage(), false),HttpStatus.NOT_FOUND);
        }
        catch (ExpiredJwtException exception){
            new ResponseEntity<>(new APIResponse(exception.getMessage(), false),HttpStatus.NOT_FOUND);
        }catch (MalformedJwtException exceptions){
            new ResponseEntity<>(new APIResponse(exceptions.getMessage(), false),HttpStatus.NOT_FOUND);
        }

        filterChain.doFilter(request,response);
    }
}
