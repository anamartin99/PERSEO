package com.perseo.service;

import com.perseo.model.Cart;
import com.perseo.model.CartItem;
import com.perseo.model.Course;
import com.perseo.repositories.ICartRepository;
import com.perseo.repositories.ICartItemRepository;
import com.perseo.repositories.ICourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    private final ICartRepository iCartRepository;
    private final ICartItemRepository iCartItemRepository;
    private final ICourseRepository iCourseRepository;

    public CartService(ICartRepository iCartRepository, ICartItemRepository iCartItemRepository, ICourseRepository iCourseRepository) {
        this.iCartRepository = iCartRepository;
        this.iCartItemRepository = iCartItemRepository;
        this.iCourseRepository = iCourseRepository;
    }

    public Cart createCart() {
        return iCartRepository.save(new Cart());
    }

    public Cart addItemToCart(Long cartId, Long courseId, int quantity) {
        Optional<Cart> cartOpt = iCartRepository.findById(cartId);
        Optional<Course> courseOpt = iCourseRepository.findById(courseId);

        if (cartOpt.isPresent() && courseOpt.isPresent()) {
            Cart cart = cartOpt.get();
            Course course = courseOpt.get();

            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setCourse(course);
            cartItem.setQuantity(quantity);

            cart.getItems().add(cartItem);
            iCartRepository.save(cart);

            return cart;
        }
        return null;
    }

    public Cart getCart(Long cartId) {
        return iCartRepository.findById(cartId).orElse(null);
    }
}