package com.ecommerce.be_ecommerce.controller;

import com.ecommerce.be_ecommerce.config.JwtProvider;
import com.ecommerce.be_ecommerce.exception.UserException;
import com.ecommerce.be_ecommerce.model.User;
import com.ecommerce.be_ecommerce.repository.UserRepository;
import com.ecommerce.be_ecommerce.request.LoginRequest;
import com.ecommerce.be_ecommerce.response.AuthResponse;
import com.ecommerce.be_ecommerce.service.impl.CustomUserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserRepository userRepository;
    private JwtProvider jwtProvider;

    private PasswordEncoder passwordEncoder;
    private CustomUserServiceImpl customUserServiceImpl;

    public AuthController(UserRepository userRepository, JwtProvider jwtProvider, PasswordEncoder passwordEncoder, CustomUserServiceImpl customUserServiceImpl){
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.customUserServiceImpl = customUserServiceImpl;

    }


    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException{
        String email = user.getEmail();
        String password = user.getPassword();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        User isEmailExist = userRepository.findByEmail(email);
        if(isEmailExist != null){
            throw new UserException("Email already exist");
        }


        User createdUser = new User();
        createdUser.setEmail(email);
        createdUser.setPassword(passwordEncoder.encode(password));
        createdUser.setFirstName(firstName);
        createdUser.setLastName(lastName);

        User savedUser = userRepository.save(createdUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Signup Success");
        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);

    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest) throws UserException{
        String username = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        Authentication authentication = authenticate(username, password);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Signin Success");

        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);


    }

    private Authentication authenticate(String username, String password) {
        UserDetails userDetails = customUserServiceImpl.loadUserByUsername(username);
        System.out.println(userDetails.getUsername());
        if(userDetails == null){
            throw new BadCredentialsException("Invalid Username");
        }
        if(!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid Password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

}
