package com.ecommerce.be_ecommerce.controller;

import com.ecommerce.be_ecommerce.exception.OrderException;
import com.ecommerce.be_ecommerce.model.Order;
import com.ecommerce.be_ecommerce.response.ApiResponse;
import com.ecommerce.be_ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/orders")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/confirmed")
    public ResponseEntity<Order> confirmedOrder(@PathVariable Long orderId, @RequestHeader("Authorization") String token) throws OrderException {
        Order order = orderService.confirmedOrder(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/shipped")
    public ResponseEntity<Order> shippedOrder(@PathVariable Long orderId, @RequestHeader("Authorization") String token) throws OrderException {
        Order order = orderService.shippedOrder(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/delivered")
    public ResponseEntity<Order> deliveredOrder(@PathVariable Long orderId, @RequestHeader("Authorization") String token) throws OrderException {
        Order order = orderService.deliveredOrder(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/cancelled")
    public ResponseEntity<Order> cancelledOrder(@PathVariable Long orderId, @RequestHeader("Authorization") String token) throws OrderException {
        Order order = orderService.cancelledOrder(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}/delete")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable Long orderId, @RequestHeader("Authorization") String token) throws OrderException {
        orderService.deleteOrder(orderId);
        ApiResponse res = new ApiResponse();
        res.setMessage("Order deleted successfully");
        res.setStatus(true);
        return new ResponseEntity<ApiResponse>(res, HttpStatus.OK);

    }
}
