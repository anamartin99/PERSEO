package com.perseo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.perseo.dtos.AuthResponse;
import com.perseo.dtos.LoginRequest;
import com.perseo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    public AuthController() {}

    @PostMapping("/login")
    public @ResponseBody AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}