package com.arbaz.blog.ServiceImplementation;

import com.arbaz.blog.Entity.CustomUserDetails;
import com.arbaz.blog.Entity.User;
import com.arbaz.blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = this.userRepository.findByUserName(username);
        return user.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException(username+"Username Doesn't Exist"));
    }
}
