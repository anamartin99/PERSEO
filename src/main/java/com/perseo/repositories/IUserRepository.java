package com.perseo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.perseo.model.User;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);

}
