package com.ssaxel03.simplequote.controllers;

import com.ssaxel03.simplequote.daos.UserDao;
import com.ssaxel03.simplequote.data.LoginDTO;
import com.ssaxel03.simplequote.data.RegisterDTO;
import com.ssaxel03.simplequote.model.Role;
import com.ssaxel03.simplequote.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserDao userDao, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {

        if(userDao.existsByUsername(registerDTO.getUsername())) {
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setRole(Role.ROLE_USER.getRole());

        userDao.saveOrUpdate(user);

        return new ResponseEntity<>("User registered.", HttpStatus.OK);


    }


    @PostMapping("/login")
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
