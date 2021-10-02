package com.kurdi.springsecurity.controllers;

import com.kurdi.springsecurity.entities.AppUser;
import com.kurdi.springsecurity.entities.Authority;
import com.kurdi.springsecurity.repositories.UserRepository;
import com.kurdi.springsecurity.security.CustomUserDetails;
import com.kurdi.springsecurity.security.Permissions;
import com.kurdi.springsecurity.security.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/")
    public String guest()
    {
        return "welcome guest";
    }

    @GetMapping("/user")
    public String welcome(){return "welcome user";}

    @GetMapping("/admin")
    public String admin()
    {
        return "welcome admin";
    }


}
