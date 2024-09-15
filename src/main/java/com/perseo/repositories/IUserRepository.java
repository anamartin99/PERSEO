package com.perseo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.perseo.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

