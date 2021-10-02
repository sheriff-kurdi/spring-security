package com.kurdi.springsecurity.controllers;

import com.kurdi.springsecurity.entities.AppUser;
import com.kurdi.springsecurity.entities.Authority;
import com.kurdi.springsecurity.repositories.UserRepository;
import com.kurdi.springsecurity.security.Permissions;
import com.kurdi.springsecurity.security.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public ResponseEntity<String> register()
    {
        List<Authority> authorities = new ArrayList<>();
        AppUser user = AppUser.builder()
                .username("sheriff")
                .password(passwordEncoder.encode("123"))
                .authorities(authorities)
                .build();

        authorities.add(Authority
                .builder()
                .appUser(user)
                .name(Roles.ADMIN.getRole())
                .build());

        authorities.add(Authority
                .builder()
                .appUser(user)
                .name(Permissions.EmployeeRead.getPermission())
                .build());

        if(userRepository.findUserByUsername(user.getUsername()).isEmpty())
        {
            userRepository.save(user);
        }


        return ResponseEntity.ok(user.getUsername());
    }
}
