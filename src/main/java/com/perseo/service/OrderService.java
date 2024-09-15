package com.perseo.service;

import com.perseo.model.*;
import com.perseo.repositories.IOrderRepository;
import com.perseo.repositories.ICartRepository;

import java.util.Optional;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final IOrderRepository iOrderRepository;
    private final ICartRepository iCartRepository;

    public OrderService(IOrderRepository iOrderRepository, ICartRepository iCartRepository) {
        this.iOrderRepository = iOrderRepository;
        this.iCartRepository = iCartRepository;
    }

    public Order placeOrder(Long cartId, User user) {
        Optional<Cart> cart = iCartRepository.findById(cartId); 
        if (cart.isPresent()) {
            Order order = new Order();
            order.setUser(user);
            order.setItems(cart.get().getItems().stream().map(item -> {
                OrderItem orderItem = new OrderItem();
                orderItem.setCourse(item.getCourse());
                orderItem.setQuantity(item.getQuantity());
                return orderItem;
            }).collect(Collectors.toSet()));
            return iOrderRepository.save(order);
        }
        return null;
    }    
}