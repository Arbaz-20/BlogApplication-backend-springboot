package com.arbaz.blog.ServiceImplementation;

import com.arbaz.blog.Entity.User;
import com.arbaz.blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),new ArrayList<>());
    }
}
