package com.ssaxel03.simplequote.controllers;

import com.ssaxel03.simplequote.daos.UserDao;
import com.ssaxel03.simplequote.data.LoginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    private AuthenticationManager authenticationManager;
    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String getLogin() {
        return "login";
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDto, @RequestParam String role) {

        if("guest".equals(role)) {

        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>("User signed in.", HttpStatus.OK);
    }
}
