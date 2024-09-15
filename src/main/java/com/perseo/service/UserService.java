package com.perseo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perseo.model.User;
import com.perseo.repositories.IUserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;

    public User registerUser(User user) {
        user.setRole("USER"); 
        return iUserRepository.save(user);
    }

    public User registerAdmin(User admin) {
        admin.setRole("ADMIN");
        return iUserRepository.save(admin);
    }

    public Optional<User> findUserById(Long id) {
        return iUserRepository.findById(id);
    }

    public UserService(IUserRepository userRepository) {
        this.iUserRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        return iUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }
}