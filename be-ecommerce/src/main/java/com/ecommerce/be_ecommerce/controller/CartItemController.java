package com.ecommerce.be_ecommerce.controller;

import com.ecommerce.be_ecommerce.exception.CartItemException;
import com.ecommerce.be_ecommerce.exception.UserException;
import com.ecommerce.be_ecommerce.model.CartItem;
import com.ecommerce.be_ecommerce.model.User;
import com.ecommerce.be_ecommerce.response.ApiResponse;
import com.ecommerce.be_ecommerce.service.CartItemService;
import com.ecommerce.be_ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart_items")
public class CartItemController {
    @Autowired
    private UserService userService;
    @Autowired
    private CartItemService cartItemService;

    @DeleteMapping("/{cartItemId}")
//    @Operation(description = "Remove Cart Item from Cart")
//    io.swagger.v3.oas.annotations.responses.ApiResponse( description = "Cart Item Removed Successfully"),
    public ResponseEntity<ApiResponse> removeCartItem(@PathVariable Long cartItemId, @RequestHeader("Authorization") String token) throws UserException, CartItemException {
        User user = userService.findUserProfileByJwt(token);
        cartItemService.removeCartItem(user.getId(), cartItemId);
        ApiResponse res = new ApiResponse();
        res.setMessage("Item removed successfully");
        res.setStatus(true);
        return new ResponseEntity<ApiResponse>(res, HttpStatus.OK);
    }
    @PutMapping("/{cartItemId}")
//    @Operation(description = "Update Cart Item In Cart")
    public ResponseEntity<CartItem> updateCartItem(
            @RequestBody CartItem cartItem,
            @PathVariable Long cartItemId,
            @RequestHeader("Authorization") String token
    ) throws UserException, CartItemException {
        User user = userService.findUserProfileByJwt(token);
        CartItem updatedCartItem = cartItemService.updateCartItem(user.getId(), cartItemId, cartItem);
        return new ResponseEntity<CartItem>(updatedCartItem, HttpStatus.OK);
    }
}
