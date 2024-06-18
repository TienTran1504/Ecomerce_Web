package com.ecommerce.be_ecommerce.controller;

import com.ecommerce.be_ecommerce.exception.OrderException;
import com.ecommerce.be_ecommerce.exception.UserException;
import com.ecommerce.be_ecommerce.model.Address;
import com.ecommerce.be_ecommerce.model.Order;
import com.ecommerce.be_ecommerce.model.User;
import com.ecommerce.be_ecommerce.service.OrderService;
import com.ecommerce.be_ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@SecurityRequirement(
        name = "Bearer Authentication"
)
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Order>createOrder(@RequestBody Address shippingAddress, @RequestHeader("Authorization") String token) throws UserException, OrderException {
        User user = userService.findUserProfileByJwt(token);
        Order order = orderService.createOrder(user, shippingAddress);
        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Order>> userOrderHistory(@RequestHeader("Authorization") String token) throws UserException {
        User user = userService.findUserProfileByJwt(token);
        List<Order> orders = orderService.userOrderHistory(user.getId());
        return new ResponseEntity<List<Order>>(orders, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> findOrderById(
            @PathVariable Long orderId,
            @RequestHeader("Authorization") String token) throws UserException, OrderException {
        User user = userService.findUserProfileByJwt(token);
        Order order = orderService.findOrderById(orderId);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
