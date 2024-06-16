package com.ecommerce.be_ecommerce.service.impl;

import com.ecommerce.be_ecommerce.exception.OrderException;
import com.ecommerce.be_ecommerce.model.Address;
import com.ecommerce.be_ecommerce.model.Order;
import com.ecommerce.be_ecommerce.model.User;
import com.ecommerce.be_ecommerce.repository.CartRepository;
import com.ecommerce.be_ecommerce.service.CartItemService;
import com.ecommerce.be_ecommerce.service.OrderService;
import com.ecommerce.be_ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private CartRepository cartRepository;
    private CartItemService cartItemService;
    private ProductService productService;

    public OrderServiceImpl(CartRepository cartRepository, CartItemService cartItemService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.cartItemService= cartItemService;
        this.productService = productService;
    }
    @Override
    public Order createOrder(User user, Address shippingAddress) throws OrderException {
        return null;
    }

    @Override
    public List<Order> userOrderHistory(Long userId) {
        return null;
    }

    @Override
    public Order placedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order confirmedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order shippedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order deliveredOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order cancelledOrder(Long orderId) throws OrderException {
        return null;
    }
}
