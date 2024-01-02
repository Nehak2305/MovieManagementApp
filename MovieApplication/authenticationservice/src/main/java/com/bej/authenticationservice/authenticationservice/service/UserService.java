package com.bej.authenticationservice.authenticationservice.service;

import com.bej.authenticationservice.authenticationservice.domain.User;
import com.bej.authenticationservice.authenticationservice.exception.InvalidCredentialsException;
import com.bej.authenticationservice.authenticationservice.exception.UserAlreadyExistsException;

public interface UserService {
    public User addUser(User user) throws UserAlreadyExistsException;


    User findByEmailAndPassword(String email, String password) throws InvalidCredentialsException;
}
