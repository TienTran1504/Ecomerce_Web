package com.ecommerce.be_ecommerce.service.impl;

import com.ecommerce.be_ecommerce.exception.UserException;
import com.ecommerce.be_ecommerce.model.User;
import com.ecommerce.be_ecommerce.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public User findUserById(Long userId) throws UserException {
        return null;
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        return null;
    }
}
