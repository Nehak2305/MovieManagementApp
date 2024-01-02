package com.bej.authenticationservice.authenticationservice.controller;

import com.bej.authenticationservice.authenticationservice.domain.User;
import com.bej.authenticationservice.authenticationservice.exception.InvalidCredentialsException;
import com.bej.authenticationservice.authenticationservice.exception.UserAlreadyExistsException;
import com.bej.authenticationservice.authenticationservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/v1")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }
    @PostMapping("/register")      //http://localhost:8081/api/v1/register
   // @CrossOrigin(origins="http://localhost:4200")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
    }
    @PostMapping("/login") //http://localhost:8081/api/v1/login
   // @CrossOrigin(origins="http://localhost:4200")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws InvalidCredentialsException
    {
        User retrievedUser = userService.findByEmailAndPassword(user.getEmail(),user.getPassword());
        if(retrievedUser==null)
        {
            throw new InvalidCredentialsException();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
