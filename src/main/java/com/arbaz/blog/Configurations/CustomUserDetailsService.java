package com.arbaz.blog.Configurations;


import com.arbaz.blog.Entity.User;
import com.arbaz.blog.Exceptions.ResourceNotFoundException;
import com.arbaz.blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Error Occured due to some error
        User user = this.userRepository.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User","Email:"+username,0));
        return user;
    }
}
