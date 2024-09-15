package com.perseo.repositories;

import com.perseo.model.Cart;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart, Long> {
        Optional<Cart> findById();

}
