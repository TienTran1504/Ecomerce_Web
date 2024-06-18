package com.ecommerce.be_ecommerce.controller;

import com.ecommerce.be_ecommerce.exception.ProductException;
import com.ecommerce.be_ecommerce.exception.UserException;
import com.ecommerce.be_ecommerce.model.Rating;
import com.ecommerce.be_ecommerce.model.User;
import com.ecommerce.be_ecommerce.request.RatingRequest;
import com.ecommerce.be_ecommerce.service.RatingService;
import com.ecommerce.be_ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
@SecurityRequirement(
        name = "Bearer Authentication"
)
public class RatingController {
    @Autowired
    private UserService userService;

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody RatingRequest req, @RequestHeader("Authorization") String token)
    throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(token);
        Rating rating = ratingService.createRating(req,user);
        return new ResponseEntity<Rating>( rating, HttpStatus.CREATED);

    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductsRating(@PathVariable Long productId, @RequestHeader("Authorization") String token) throws UserException, ProductException{
        User user = userService.findUserProfileByJwt(token);
        List<Rating> ratings = ratingService.getProductsRating(productId);
        return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
    }
}
