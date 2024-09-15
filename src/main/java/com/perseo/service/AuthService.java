package com.perseo.service;

import org.springframework.stereotype.Service;
import com.perseo.dtos.AuthResponse;
import com.perseo.dtos.LoginRequest;
import com.perseo.model.User;
import com.perseo.repositories.IUserRepository;
import com.perseo.security.JwtService;

@Service
public class AuthService {

    private final IUserRepository userRepository;
    private final JwtService jwtService;

    public AuthService(IUserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (user.getPassword().equals(request.getPassword())) {
            String token = jwtService.generateToken(user.getEmail());
            return new AuthResponse(token);
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }
}