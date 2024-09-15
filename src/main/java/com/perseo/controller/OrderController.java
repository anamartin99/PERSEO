package com.perseo.controller;

import com.perseo.model.Order;
import com.perseo.model.User;
import com.perseo.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order placeOrder(@RequestParam Long cartId, @RequestParam User user) {
        return orderService.placeOrder(cartId, user);

    }

}