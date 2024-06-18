package com.ecommerce.be_ecommerce.controller;

import com.ecommerce.be_ecommerce.exception.ProductException;
import com.ecommerce.be_ecommerce.exception.UserException;
import com.ecommerce.be_ecommerce.model.Cart;
import com.ecommerce.be_ecommerce.model.User;
import com.ecommerce.be_ecommerce.request.AddItemRequest;
import com.ecommerce.be_ecommerce.response.ApiResponse;
import com.ecommerce.be_ecommerce.service.CartService;
import com.ecommerce.be_ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cart")
@SecurityRequirement(
        name = "Bearer Authentication"
)
//@Tag(name = "Cart Management", description = "Find User's Cart, Add Item To Cart"
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping
//    @Operation(description= "Get User's Cart")
    public ResponseEntity<Cart>findUserCart(@RequestHeader("Authorization") String token) throws UserException {
        User user = userService.findUserProfileByJwt(token);
        Cart cart = cartService.findUserCart(user.getId());
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @PutMapping("/add")
//    @Operation(description ="Add Item To Cart")
    public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest req, @RequestHeader("Authorization") String token) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(token);
        cartService.addCartItem(user.getId(), req);
        ApiResponse res = new ApiResponse();
        res.setMessage("Item added to cart successfully");
        res.setStatus(true);
        return new ResponseEntity<ApiResponse>(res, HttpStatus.OK);
    }
}
