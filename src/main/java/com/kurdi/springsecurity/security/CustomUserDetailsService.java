package com.kurdi.springsecurity.security;

import com.kurdi.springsecurity.entities.AppUser;
import com.kurdi.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public CustomUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Supplier<UsernameNotFoundException> s =
                () -> new UsernameNotFoundException(
                        "Problem during authentication!");

        AppUser u = userRepository
                .findUserByUsername(userName)
                .orElseThrow(s);


        return new CustomUserDetails(u);
    }
}
